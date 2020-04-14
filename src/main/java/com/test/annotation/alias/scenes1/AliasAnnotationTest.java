package com.test.annotation.alias.scenes1;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.AnnotatedElement;
import java.util.function.Consumer;

public class AliasAnnotationTest {

    @Test
    public void test1() throws NoSuchMethodException {
        Consumer<AliasAnnotation> logic = c -> {
            System.out.println(c.value());
            System.out.println(c.location());
            //
            System.out.println(c.value().equals(c.location()));
        };

        //findAnnotation这个方法也仅仅是通过jdk递归遍历，采用了一点缓存，没有看到ASM的身影
        AliasAnnotation aliasAnnotation = AnnotationUtils.findAnnotation(AliasAnnotationApp.class
                                                        .getMethod("method1"), AliasAnnotation.class);
        logic.accept(aliasAnnotation);

        AliasAnnotation aliasAnnotation2 = AnnotationUtils.findAnnotation(AliasAnnotationApp.class
                                                        .getMethod("method2"), AliasAnnotation.class);
        logic.accept(aliasAnnotation2);

    }

}
