package cn.sicnu.itelites.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationFlied {
    //此属性是否可为null，即没有此字段
    public boolean notNull() default false;

    //Validation.properties中对应的key
    public String key();
}
