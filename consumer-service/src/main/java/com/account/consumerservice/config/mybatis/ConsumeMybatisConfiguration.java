package com.account.consumerservice.config.mybatis;

import com.account.consumerservice.config.druid.DruidDataSourceConfiguration;
import com.account.consumerservice.config.druid.SlaveNumberSettings;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 自定义实现mybatisConfiguration信息
 * @date 2019/5/23 - 10:55 -- 星期四
 */
@Slf4j
@Configuration
@ConditionalOnClass({EnableTransactionManagement.class})
@Import({DruidDataSourceConfiguration.class, SlaveNumberSettings.class})
public class ConsumeMybatisConfiguration{

    @Autowired
    private SlaveNumberSettings slaveNumberSettings;
    /**
     *
     * @param context
     * @return
     * @throws Exception
     */
    @Bean
    @ConditionalOnMissingBean()
    public SqlSessionFactory sqlSessionFactory(ApplicationContext context)throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(roundRobinDataSouceProxy(context));
        //ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mappings/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.account.consumerservice.core.dao");
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 有多少个数据源就要配置多少个bean
     * @return
     */
    @Bean
    public AbstractRoutingDataSource roundRobinDataSouceProxy(ApplicationContext ac) {
        int size = slaveNumberSettings.getSlaveNumber();
        log.info("current system has configured "+size+"slave datasources!");
        ConsumeRoutingDataSource proxy = new ConsumeRoutingDataSource(size);
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        //多个读数据库时
        DataSource writeDataSource = (DataSource)ac.getBean("writeDataSource");
        List<DataSource> readDataSources = (List<DataSource>)ac.getBean("readDataSources");
        for (int i = 0; i < size; i++) {
            targetDataSources.put(i, readDataSources.get(i));
        }
        proxy.setDefaultTargetDataSource(writeDataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }
}
