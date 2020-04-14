package com.test.annotation.alias.scenes2;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1、@AliasFor 的第二层意思覆盖指定注解的特定属性，一般是覆盖父注解
 * 2、如果是通过spring AnnotatedElementUtils.findMergedAnnotation
 * 那么不用@AliasFor，子注解只要定义和父注解一样的属性也能实现覆盖父注解的效果，value属性除外
 * 3、
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AnnotaionBase(value = "v",tval = "base")
public @interface AnnotationChild {
    String value() default "";


    /**
     * @AliasFor(annotation = AnnotaionBase.class, attribute = "value")
     * 可以任意覆盖父类属性
     */
//    @AliasFor(annotation = AnnotaionBase.class, attribute = "value")
    String tval();

}