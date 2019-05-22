package com.account.consumerservice.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author cuitao
 * @version V1.0
 * @Description: 自定义druidMonitorFilter实现对druid的控制台
 * @date 2019/5/22 - 14:19 -- 星期三
 */
@WebFilter(filterName = "druidStatFilter",urlPatterns = "/*",
            initParams = {
        @WebInitParam(name="exclusions",value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*,ico,/druid/*")//忽略资源过滤
            })
public class DruidStatFilter extends WebStatFilter{

}
