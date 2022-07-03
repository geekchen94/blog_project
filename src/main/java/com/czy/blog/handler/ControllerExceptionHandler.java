package com.czy.blog.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//拦截异常
@ControllerAdvice
public class ControllerExceptionHandler {

    //    获取日志对象
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());


    /**
     * @Description: 错误异常处理
     * @Auther: czy
     * @Date: 15:52 2020/6/19
     * @Param: request:出错的URL;
     *          e:异常
     * @Return: 返回一个错误页面
     */
    @ExceptionHandler(Exception.class)      //标识异常的注解
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Requst URL : {}，Exception : {}", request.getRequestURL(),e);

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
