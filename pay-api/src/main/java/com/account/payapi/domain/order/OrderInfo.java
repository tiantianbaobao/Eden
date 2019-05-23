package com.account.payapi.domain.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 订单实体类
 * @date 2019/5/22 - 23:08 -- 星期三
 */
@Data
public class OrderInfo implements Serializable{

    /**
     * 记录ID
     */
    private int orderInfoId;
    /***
     * 当前订单的所属客户
     */
    private int customInfoId;
    /***
     * 当前订单总金额
     */
    private BigDecimal orderAmount;
    /***
     * 当前订单(阶段)状态
     */
    private String orderPhase;
    /***
     * 当前订单的创建时间
     */
    private Date createTime;
    //.....待补充（基于DDD思想考虑后续的订单相关实体类）
}
