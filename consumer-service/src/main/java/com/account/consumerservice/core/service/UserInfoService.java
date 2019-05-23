package com.account.consumerservice.core.service;

import com.account.consumerservice.annotation.anno.ReadDataSource;
import com.account.consumerservice.annotation.anno.WriteDataSource;
import com.account.consumerservice.core.dao.UserInfoDao;
import com.account.consumerservice.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2019/5/22 - 14:43 -- 星期三
 */
@Service
public class UserInfoService {


    private UserInfoDao userInfoDao;
    @Autowired
    public UserInfoService(UserInfoDao userInfoDao){
        this.userInfoDao = userInfoDao;
    }
    @ReadDataSource
    public UserInfo getUserInfoFromSlave(int id){
        return userInfoDao.getUserInfo(id);
    }

    @WriteDataSource
    public UserInfo getUserInfoFromMaster(int id){
        return userInfoDao.getUserInfo(id);
    }

    public boolean saveUserInfo(UserInfo info){
        return userInfoDao.saveUserInfo(info)>0;
    }
}
