package com.account.consumerservice.core.controller;

import com.account.consumerservice.core.service.UserInfoService;
import com.alibaba.druid.support.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2019/5/22 - 14:38 -- 星期三
 */
@RestController
public class ConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/slave/{id}")
    public String slaveInfo(@PathVariable(name = "id") int id){
        return userInfoService.getUserInfoFromSlave(id).toString();
    }

    @GetMapping("/master/{id}")
    public String masterInfo(@PathVariable(name = "id") int id){

        return userInfoService.getUserInfoFromMaster(id).toString();
    }
}
