package com.account.payapi.domain.integral;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 积分变化表
 * @date 2019/5/22 - 23:05 -- 星期三
 */
@Data
public class IntegralRecord implements Serializable {
    /**
     * 记录ID
     */
    private int id;
    /***
     * 客户id
     */
    private int customId;
    /**
     * 当前操作的积分数目
     */
    private int operationNumber;
    /***
     * 当前操作积分的类型-(增加/减少)
     */
    private String operationType;
    /**
     * 当前操作的时间
     */
    private Date operationDate;
}
