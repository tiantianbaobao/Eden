package com.account.payapi.domain.integral;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 会员积分实体类
 * @date 2019/5/22 - 22:56 -- 星期三
 */
@Data
public class IntegralInfo implements Serializable {
    /**
     * 记录id
     */
    private int id;
    /**
     * 客户id
     */
    private int customId;
    /**
     * 当前积分
     */
    private int currentNumber;
    /***
     * 剩余有效期限 x days
     */
    private int lastDays;

}
