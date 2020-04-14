package com.test.annotation.alias.scenes1;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AliasAnnotation {

    @AliasFor(value = "location")   //互为别名
    String value() default "";

    @AliasFor(value = "value")      //互为别名
    String location() default "";
}