spring annotation 测试
1、注解aliasFor的应用
    a、scenes1 同一个注解的属性互为别名
    b、scenes2 标示继承关系树上注解属性override，并不是真的意义上覆盖，实际是和
    AnnotatedElementUtils.findMergedAnnotation 配合来做到子注解覆盖父注解属性；
    c、


2、spring组合注解探秘，通过spring源码学习如何探测注解的注解
   a、注解的注解不是指注解继承关系树定义后子注解属性天然就覆盖同名父注解属性，注解关系树是人为定义的，
只不过spring通过特定api实现了子注解属性覆盖父注解同名属性；
   eg：
        AnnotationUtils.findAnnotation  子注解上的父注解属性不变
        AnnotatedElementUtils.findMergedAnnotation 子注解上的父注解属性会被同名子注解覆盖，value除外（除非专用@aliasFor指定）
   b、探测注解的注解可以自己通过jdk api递归实现，也可通过spring AnnotationUtils/AnnotatedElementUtils（内部还是jdk api递归）
，只不过spring 帮我们实现了很多API



3、展示spring AnnotationUtils/AnnotatedElementUtils 探测注解的系列方法