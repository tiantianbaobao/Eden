package com.account.payapi.domain.custom;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2019/5/22 - 22:54 -- 星期三
 */
@Data
public class UserInfo implements Serializable{
    private int id;
    private String name;
    private int age;
    private String address;
}
