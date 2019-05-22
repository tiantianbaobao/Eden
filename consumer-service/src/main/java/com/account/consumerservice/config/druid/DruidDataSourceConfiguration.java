package com.account.consumerservice.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Properties;

/**
 * @author cuitao
 * @version V1.0
 * @Description: Druid数据库连接池的相关配置(spring boot 1.3.X之前采用默认配置没有问题，1.4.X之后发现监控不了sql执行)
 * @date 2019/5/22 - 14:11 -- 星期三
 */
@Configuration
@EnableConfigurationProperties(DruidSettings.class)
public class DruidDataSourceConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DruidDataSourceConfiguration.class);
    @Autowired
    private DruidSettings druidSettings;

    @Bean
    @ConfigurationProperties("spring.druid.datasource")
   // @Primary
    public DruidDataSource dataSource(
            DataSourceProperties properties) throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidSettings.getDriverClassName());
        dataSource.setUrl(druidSettings.getUrl());
        dataSource.setUsername(druidSettings.getUsername());
        dataSource.setPassword(druidSettings.getPassword());
        dataSource.setInitialSize(druidSettings.getInitialSize());
        dataSource.setMinIdle(druidSettings.getMinIdle());
        dataSource.setMaxActive(druidSettings.getMaxActive());
        dataSource.setMaxWait(druidSettings.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidSettings.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidSettings.getMinEvictableIdleTimeMillis());
        String validationQuery = druidSettings.getValidationQuery();
        if (validationQuery != null && !"".equals(validationQuery)) {
            dataSource.setValidationQuery(validationQuery);
        }
        dataSource.setTestWhileIdle(druidSettings.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidSettings.isTestOnBorrow());
        dataSource.setTestOnReturn(druidSettings.isTestOnReturn());
        if(druidSettings.isPoolPreparedStatements()){
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidSettings.getMaxPoolPreparedStatementPerConnectionSize());
        }
        dataSource.setFilters(druidSettings.getFilters());//这是最关键的,否则SQL监控无法生效
        String connectionPropertiesStr = druidSettings.getConnectionProperties();
        if(connectionPropertiesStr != null && !"".equals(connectionPropertiesStr)){
            Properties connectProperties = new Properties();
            String[] propertiesList = connectionPropertiesStr.split(";");
            for(String propertiesTmp:propertiesList){
                String[] obj = propertiesTmp.split("=");
                String key = obj[0];
                String value = obj[1];
                connectProperties.put(key,value);
            }
            dataSource.setConnectProperties(connectProperties);
        }
        dataSource.setUseGlobalDataSourceStat(druidSettings.isUseGlobalDataSourceStat());

        return dataSource;
    }
}
