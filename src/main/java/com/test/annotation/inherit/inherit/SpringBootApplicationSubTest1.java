package com.test.annotation.inherit.inherit;


import javax.annotation.*;
import java.lang.annotation.*;
import java.util.HashSet;
import java.util.Set;

/**
* @Author:         Janes
* @Description:    通过jdk 递归获取注解的注解
* @CreateDate:     2020/4/10 16:58
* @Version:        1.0
*/
public class SpringBootApplicationSubTest1 {

    public static Set<Annotation> set = new HashSet<>();

    public static void main(String[] args) {
        getAnnos(SpringBootApplicationSubApp.class);
        set.forEach(annotation -> {
            System.out.println(annotation.annotationType());
        });
    }

    public static void getAnnos(Class<?> clazz) {
        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation anno : annotations){
            boolean flag = anno.annotationType() != Deprecated.class &&
                    anno.annotationType() != SuppressWarnings.class &&
                    anno.annotationType() != Override.class &&
                    anno.annotationType() != PostConstruct.class &&
                    anno.annotationType() != PreDestroy.class &&
                    anno.annotationType() != Resource.class &&
                    anno.annotationType() != Resources.class &&
                    anno.annotationType() != Generated.class &&
                    anno.annotationType() != Target.class &&
                    anno.annotationType() != Retention.class &&
                    anno.annotationType() != Documented.class &&
                    anno.annotationType() != Inherited.class &&
                    anno.annotationType() != Repeatable.class;
            if (flag){
                set.add(anno);
                Class cla =  anno.annotationType();
                getAnnos(cla);
            }
        }



    }



}
