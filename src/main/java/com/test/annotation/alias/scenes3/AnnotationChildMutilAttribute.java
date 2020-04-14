package com.test.annotation.alias.scenes3;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AnnotaionBase
public @interface AnnotationChildMutilAttribute {

    @AliasFor(annotation = AnnotaionBase.class, attribute = "value")
    String extendValue1() default "";

    @AliasFor(annotation = AnnotaionBase.class, attribute = "value")
    String extendValue2() default "";
}
