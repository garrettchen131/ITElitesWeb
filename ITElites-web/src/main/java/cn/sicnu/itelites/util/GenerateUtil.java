package cn.sicnu.itelites.util;


import cn.sicnu.itelites.Annotation.ValidationFlied;
import cn.sicnu.itelites.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@Component
/**
 *  此类后续还需要改造！
 *  974212451@qq.com
 *  2019-10-12
 */
public class GenerateUtil {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        GenerateUtil.messageSource = messageSource;
    }

    private static HashMap<String, Pattern> regExpMap = new HashMap<>();  //TODO 这里可能涉及到线程安全问题！！！

    public static <T> T GenerateClass(Map<String, String> params, Class<T> clazz)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, ValidationException {
        Field[] fields = clazz.getDeclaredFields();
        Object obj = clazz.getConstructor().newInstance();
        for (Field field : fields) {
            boolean flag = params.containsKey(field.getName()); //获取前端传来的参数中是否包含此字段
            ValidationFlied annotation = field.getAnnotation(ValidationFlied.class);
            if (annotation != null){    //进行正则匹配验证
                boolean notNull = annotation.notNull();
                String key = annotation.key();
                if (!flag && notNull)  //如果此字段必须有，但不存在前端传来的数据中，则抛异常
                    throw new ValidationException(field.getName());

                if (!flag)
                    continue; //如果此字段没有，并且也没有规定此字段必须有，那么则继续并不进行正则验证

                //进行正则验证
                if (!regExpMap.containsKey(key)) {
                    String regExp = messageSource.getMessage(key, null, Locale.getDefault());
                    Pattern pattern = Pattern.compile(regExp);
                    regExpMap.put(key, pattern);
                    if (!pattern.matcher(params.get(field.getName()).trim()).matches())
                        throw new ValidationException(field.getName());
                } else {
                    if (!regExpMap.get(key).matcher(params.get(field.getName()).trim()).matches())
                        throw new ValidationException(field.getName());
                }
            }
            //如果此字段没有设置注解，则不进行正则验证，直接进行转换
            if (!flag) continue; //如果此字段没有，则继续
            //进行数据转换
            String str = params.get(field.getName()).trim();
            Class type = field.getType();       //此属性的Class
            String methodName = getName(field.getName());
            Method method = clazz.getMethod(methodName, type);
            method.invoke(obj, getValue(str, type));

        }
        return (T)obj;
    }


    private static Object getValue(String str, Class type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if ("String".equalsIgnoreCase(type.getTypeName()) || "java.lang.String".equalsIgnoreCase(type.getTypeName())){
            return (String) str;
        } else if ("int".equalsIgnoreCase(type.getTypeName()) || "java.lang.Integer".equalsIgnoreCase(type.getTypeName())) {
            return Integer.decode(str);
        } else if ("double".equalsIgnoreCase(type.getTypeName()) || "java.lang.Double".equalsIgnoreCase(type.getTypeName())) {
            return Double.valueOf(str);
        } else if ("long".equalsIgnoreCase(type.getTypeName()) || "java.lang.Long".equalsIgnoreCase(type.getTypeName())){
            return Long.decode(str);
        } else if ("boolean".equalsIgnoreCase(type.getTypeName()) || "java.lang.Boolean".equalsIgnoreCase(type.getTypeName())){
            return Boolean.valueOf(str);
        } else { //都不是基本类型时
            Object obj = type.getConstructor().newInstance();
            String methodName = getName(type.getSimpleName());
            Method method = type.getMethod(methodName + "Id", Integer.class);
            method.invoke(obj, getValue(str, Integer.class));
            return obj;
        }
    }

    private static String getName(String value) {
        StringBuilder sb = new StringBuilder("set");
        sb.append(value.substring(0, 1).toUpperCase());
        sb.append(value.substring(1));
        return sb.toString();
    }


}
