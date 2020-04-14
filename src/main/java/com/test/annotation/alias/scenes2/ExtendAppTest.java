package com.test.annotation.alias.scenes2;


import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

public class ExtendAppTest {

    @Test
    public void test() throws NoSuchMethodException {
        AnnotaionBase annotaionBase = AnnotatedElementUtils.findMergedAnnotation(ExtendAppClass.class, AnnotaionBase.class);
        AnnotationChild annotationChild = AnnotatedElementUtils.findMergedAnnotation(ExtendAppClass.class, AnnotationChild.class);
        System.out.println(annotaionBase.value());
        System.out.println(annotaionBase.tval());
        System.out.println(annotationChild.value());
        System.out.println(annotationChild.tval());

    }


}
