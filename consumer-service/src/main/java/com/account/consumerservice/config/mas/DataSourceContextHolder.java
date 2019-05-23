package com.account.consumerservice.config.mas;

import com.account.consumerservice.annotation.common.MasterOrSlaverEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 创建DatasourceContextHolder处理
 * @date 2019/5/23 - 10:07 -- 星期四
 */
@Component
@Slf4j
public class DataSourceContextHolder {
    private static final ThreadLocal<String> local = new ThreadLocal<>();
    public static ThreadLocal<String> getLocal(){
        return local;
    }

    /**
     * 切换到读库（从库）
     */
    public static void readOperation(){
        local.set(MasterOrSlaverEnum.SLAVE.name());
        log.info("current datasource has changed SLAVE-DATASOURCE");
    }

    /**
     * 切换到写库（主库）
     */
    public static void writeOperation(){
        local.set(MasterOrSlaverEnum.MASTER.name());
        log.info("current datasource has changed MASTER-DATASOURCE");
    }

    /***
     * 获取当前的datasource的type类型
     * @return
     */
    public static String getCurrentDataSourceType(){
        return local.get();
    }
}
