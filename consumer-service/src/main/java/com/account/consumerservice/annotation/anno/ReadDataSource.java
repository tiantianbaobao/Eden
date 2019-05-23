package com.account.consumerservice.annotation.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 代表当前切换（读库）从库
 * @date 2019/5/23 - 11:44 -- 星期四
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadDataSource {
    String description() default "";
}
