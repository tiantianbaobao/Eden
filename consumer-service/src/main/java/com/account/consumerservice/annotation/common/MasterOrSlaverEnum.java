package com.account.consumerservice.annotation.common;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2019/5/23 - 9:41 -- 星期四
 */
public enum MasterOrSlaverEnum {
    /**
     * 代表主库，主要实现数据的写操作
     */
    MASTER,
    /**
     * 代表从库，实现数据的读操作
     */
    SLAVE;
}
