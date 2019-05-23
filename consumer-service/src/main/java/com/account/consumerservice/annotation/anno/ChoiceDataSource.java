package com.account.consumerservice.annotation.anno;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 自定义注解---切换数据源
 * @date 2019/5/23 - 9:31 -- 星期四
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChoiceDataSource {
    /***
     * 选择数据库
     * @return
     */
    @AliasFor("name")
    String value();

    /***
     *
     * @return
     */
    @AliasFor("value")
    String name();

    /***
     * 说明
     * @return
     */
    String description() default "change datasource";
}
