package com.readailib.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/*
 * @program: girl
 * @description: aspect
 * @Author: ReadAILib
 * @create: 2018-03-21 09:02
 **/
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger =  LoggerFactory.getLogger(HttpAspect.class);

    /** 
    * @Description: 定义一个公用的方法，log，表示切点 
    * @Param: [] 
    * @return: void 
    * @Author: ReadAILib
    * @Date: 2018/3/21 
    */ 
    @Pointcut("execution(public * com.readailib.girl.controller.GirlController.*(..))")
    public  void log(){
    }

    /** 
    * @Description: 表示执行方法之前，打印出1111111 
    * @Param: [] 
    * @return: void 
    * @Author: ReadAILib
    * @Date: 2018/3/21 
    */ 
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("URL={}", request.getRequestURL());

        //method
        logger.info("Methd={}", request.getMethod());

        //ip
        logger.info("IP={}", request.getRemoteAddr());

        // class method
        logger.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());

        //参数
        logger.info("args = {}", joinPoint.getArgs());

    }

    /** 
    * @Description: 表示执行方法完成后，打印日志信息222222
    * @Param: [] 
    * @return: void 
    * @Author: ReadAILib
    * @Date: 2018/3/21 
    */ 
    @After("log()")
    public  void doAfter(){
        logger.info("222222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){

        //logger.info("response={}", object.toString());
    }
}
