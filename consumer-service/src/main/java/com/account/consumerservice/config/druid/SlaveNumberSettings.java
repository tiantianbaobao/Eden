package com.account.consumerservice.config.druid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 配置从库的数量
 * @date 2019/5/23 - 18:29 -- 星期四
 */
@Component
@ConfigurationProperties(prefix = "system.slave.number")
@PropertySource(value="classpath:druid-config.properties")
@Data
public class SlaveNumberSettings implements Serializable{
    /**
     * 配置从库的数量
     */
    private int slaveNumber;
}
