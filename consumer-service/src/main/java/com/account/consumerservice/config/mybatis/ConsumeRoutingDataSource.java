package com.account.consumerservice.config.mybatis;

import com.account.consumerservice.annotation.common.MasterOrSlaverEnum;
import com.account.consumerservice.config.mas.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 自定义路由数据源
 * @date 2019/5/23 - 11:00 -- 星期四
 */
public class ConsumeRoutingDataSource extends AbstractRoutingDataSource{
    private final int dataSourceNumber;
    private AtomicInteger count = new AtomicInteger(0);
    public ConsumeRoutingDataSource(int dataSourceNumber) {
        this.dataSourceNumber = dataSourceNumber;
    }
    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.getCurrentDataSourceType();
        if (typeKey.equals(MasterOrSlaverEnum.MASTER.name())) {
            return MasterOrSlaverEnum.MASTER.name();
        }
        // 读 简单负载均衡
        int number = count.getAndAdd(1);
        int lookupKey = number % dataSourceNumber;
        return new Integer(lookupKey);
    }
}
