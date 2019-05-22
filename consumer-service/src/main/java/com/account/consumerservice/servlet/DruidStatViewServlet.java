package com.account.consumerservice.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author cuitao
 * @version V1.0
 * @Description: DruidStatViewServlet
 * @date 2019/5/22 - 14:31 -- 星期三
 */
@WebServlet(urlPatterns = "/druid/*",
initParams = {
        @WebInitParam(name="allow",value ="127.0.0.1" ),//IP白名单，多个白名单共同存在时采用逗号分开
        @WebInitParam(name="deny",value ="192.168.16.111" ),//IP黑名单（allow和deny同时存在时候，deny优先于allow）
        @WebInitParam(name="loginUsername",value ="admin" ),//用户名
        @WebInitParam(name="loginPassword",value ="123456" ),//密码
        @WebInitParam(name="resetEnable",value ="false" ),//禁用HTML页面上的“reset all”功能
})
public class DruidStatViewServlet extends StatViewServlet {
}
