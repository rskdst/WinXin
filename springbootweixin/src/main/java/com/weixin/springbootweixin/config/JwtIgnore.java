package com.weixin.springbootweixin.config;

import java.lang.annotation.*;

/**
 * 授权注解，用该注解标注的方法，拦截器不拦截
 */
//@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//public @interface JwtIgnore {
//}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
    String[] roles() default {};
}