package com.account.consumerservice.aspect;

import com.account.consumerservice.config.mas.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author cuitao
 * @version V1.0
 * @Description: DataSource切面类,并声明为一个bean
 * @date 2019/5/23 - 9:50 -- 星期四
 */
@Slf4j
@Aspect
@Component
@Order(value=1)
public class DataSourceAspect implements Serializable{

    /***
     * 声明一个切入点
     */
    @Pointcut("@annotation(com.account.consumerservice.annotation.anno.ChoiceDataSource)")
    public void operationPoint(){}

    /**
     * 写库切换切入点
     */
    @Pointcut("@annotation(com.account.consumerservice.annotation.anno.WriteDataSource)")
    public void writeMethod(){}

    /**
     * 读库切换切入点
     */
    @Pointcut("@annotation(com.account.consumerservice.annotation.anno.ReadDataSource)")
    public void readMethod(){}

    @Before("writeMethod()")
    public void writeProceed(JoinPoint joinPoint) throws Throwable {
        DataSourceContextHolder.writeOperation();
        log.info("System has changed to writeDataSource! Target method is "+joinPoint.getSignature().getName()+".");
    }

    @Before("readMethod()")
    public void readProceed(JoinPoint joinPoint) throws Throwable {
        DataSourceContextHolder.readOperation();
        log.info("System has changed to readDataSource! Target method is "+joinPoint.getSignature().getName()+".");
    }
}
