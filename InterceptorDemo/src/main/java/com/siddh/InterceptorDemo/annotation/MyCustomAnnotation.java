package com.siddh.InterceptorDemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {
    String key() default "defaultKeyName"; //doesn't have any parameter and return type is String

    int intKey() default 0;

    Class<?> classTypeKey() default String.class;
}
