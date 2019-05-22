package com.account.consumerservice.core.dao;

import com.account.consumerservice.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2019/5/22 - 14:42 -- 星期三
 */
@Mapper
@Repository
public interface UserInfoDao {
    /***
     * 查询信息根据id
     * @param id
     * @return
     */
    @Select("select * from test_user where id=#{id}")
    UserInfo getUserInfo(int id);

    @Insert("INSERT INTO test_user(name,age) VALUES(#{name},#{age})")
    int saveUserInfo(UserInfo info);
}
