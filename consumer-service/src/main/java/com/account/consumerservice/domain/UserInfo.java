package com.account.consumerservice.domain;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2019/5/22 - 14:44 -- 星期三
 */
@Data
@JsonRootName("userInfo")
public class UserInfo {
    private int id;
    private String name;
    private int age;
}
