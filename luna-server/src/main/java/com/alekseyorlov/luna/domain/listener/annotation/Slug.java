package com.alekseyorlov.luna.domain.listener.annotation;

import com.alekseyorlov.luna.domain.listener.annotation.support.DefaultSlugGenerationStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Slug {

    String source();

    Class strategy() default DefaultSlugGenerationStrategy.class;

}
