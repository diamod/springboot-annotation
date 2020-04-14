package com.test.annotation.alias.scenes3;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

public class ExtendMutilClassTest {
    @Test
    public void test(){
        AnnotationChildMutilAttribute mergedAnnotation1 = AnnotatedElementUtils.findMergedAnnotation(
                ExtendMutilClass.extendValue1.class, AnnotationChildMutilAttribute.class);
        Assert.assertTrue(mergedAnnotation1.extendValue1().equals("extendValue1"));
        Assert.assertTrue(mergedAnnotation1.extendValue2().equals("extendValue1"));

        AnnotationChildMutilAttribute mergedAnnotation2 = AnnotatedElementUtils.findMergedAnnotation(
                ExtendMutilClass.extendValue2.class, AnnotationChildMutilAttribute.class);
        Assert.assertTrue(mergedAnnotation2.extendValue1().equals("extendValue2"));
        Assert.assertTrue(mergedAnnotation2.extendValue2().equals("extendValue2"));
    }

}
