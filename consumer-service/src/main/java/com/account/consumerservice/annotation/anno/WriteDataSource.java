package com.account.consumerservice.annotation.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 切换写库（主库）标识
 * @date 2019/5/23 - 11:40 -- 星期四
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WriteDataSource {
    String description() default "";
}
