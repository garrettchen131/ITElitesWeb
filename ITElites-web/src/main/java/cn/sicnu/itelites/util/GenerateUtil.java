package cn.sicnu.itelites.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class GenerateUtil {


    public static <T> T GenerateClass(Map<String, String> params, Class<T> clazz)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Field[] fields = clazz.getDeclaredFields();
        Object obj = clazz.getConstructor().newInstance();
        for (Field field : fields) {
            if (params.containsKey(field.getName())) {
                String str = params.get(field.getName());
                Class type = field.getType();       //此属性的Class
                String methodName = getName(field.getName());
                Method method = clazz.getMethod(methodName, type);
                method.invoke(obj, getValue(str, type));
            }
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
