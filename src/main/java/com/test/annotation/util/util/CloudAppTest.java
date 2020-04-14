package com.test.annotation.util.util;

import com.test.annotation.alias.scenes1.AliasAnnotation;
import com.test.annotation.alias.scenes1.AliasAnnotationApp;
import com.test.annotation.alias.scenes2.AnnotaionBase;
import com.test.annotation.alias.scenes2.AnnotationChild;
import com.test.annotation.alias.scenes2.ExtendAppClass;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;


public class CloudAppTest {

    public static void main(String[] args) {

        //class参数，在注解的注解、接口、父类上去找
        SpringBootConfiguration sba1 = AnnotationUtils.findAnnotation(CloudApplication.class,
                SpringBootConfiguration.class);
        System.out.println(sba1);

        //AnnotatedElement参数，仅仅在注解的注解上去找
        SpringBootConfiguration sba2 = AnnotationUtils.findAnnotation((AnnotatedElement)CloudApplication.class,
                SpringBootConfiguration.class);
        System.out.println(sba2);

        //仅仅在AnnotatedElement上去找，不会递归
        SpringBootConfiguration sba3 = AnnotationUtils.getAnnotation((AnnotatedElement)CloudApplication.class,
                SpringBootConfiguration.class);
        System.out.println(sba3);

        try {
            //AliasAnnotationApp方法上原注解实例
            AliasAnnotation aliasanno1 = (AliasAnnotation)AliasAnnotationApp.class.getMethods()[0].getAnnotations()[0];
            /**
             *基于aliasanno1合成一个新注解（采用动态代理的方式），新注解与原注解的区别是把原注解上的aliasFor给处理了
             *bak：
             *  1、注解也可以动态生成
             *  2、第二个参数貌似没啥用(可参看源码)
             */
            Annotation aliasanno2 = AnnotationUtils.synthesizeAnnotation(aliasanno1,
                                                        AliasAnnotationApp.class.getMethod("method1"));

            System.out.println(aliasanno1);
            System.out.println(aliasanno2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * findMergedAnnotation 主要是用来merge注解关系树上的父子注解属性的，当然是子注解的同名属性或@aliasFor标识的属性覆盖父注解属性
         */
        AnnotaionBase annotaionBase = AnnotatedElementUtils.findMergedAnnotation(ExtendAppClass.class, AnnotaionBase.class);
        AnnotationChild annotationChild = AnnotatedElementUtils.findMergedAnnotation(ExtendAppClass.class, AnnotationChild.class);
        System.out.println(annotaionBase.value());
        System.out.println(annotaionBase.tval());
        System.out.println(annotationChild.value());
        System.out.println(annotationChild.tval());

        //集合
        AnnotatedElementUtils.findAllMergedAnnotations(ExtendAppClass.class, AnnotaionBase.class);
    }
}
