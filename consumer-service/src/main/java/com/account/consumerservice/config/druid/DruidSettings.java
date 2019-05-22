package com.account.consumerservice.config.druid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 在spring boot 1.4.x 之后采用原传统的配置方式无法监控到sql相关的情况，现将配置重新梳理
 *                  Druid Settings配置
 *                  在1.4.x之后{@link @ConfigurationProperties}已经取消了locations参数，因此，针对这种情况的处理将总结为如下处理
 *                  重点：
 *                  添加{@link @Component}标注为组件
 *                  添加{@link @PropertySource}并标注classpath文件路径
 * @date 2019/5/22 - 15:13 -- 星期三
 */
@Component
@ConfigurationProperties(prefix = "spring.druid.datasource")
@PropertySource("classpath:druid-config.properties")
@Data
public class DruidSettings {
    private String type;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Long maxWait;
    private Long timeBetweenEvictionRunsMillis;
    private Long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String connectionProperties;
    private boolean useGlobalDataSourceStat;
}
