package com.weixin.springbootweixin.config;

import com.weixin.springbootweixin.entity.ExceptionApi;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
/**
 * 全局异常处理拦截器
 */
@ControllerAdvice
public class GlobalException {

    //处理ExceptionApi格式的异常信息
    @ExceptionHandler(value = {com.weixin.springbootweixin.entity.ExceptionApi.class}) //遇到异常信息格式是自定义的异常格式时进行处理
    public Object ApiException(ExceptionApi e){
        int code = e.getCode();
        String message = e.getMessage();
        Object data = e.getData();
        //将异常信息封装成json格式返回给前端
        ModelAndView  modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("code", code);
        modelAndView.addObject("message", message);
        modelAndView.addObject("data", data);
        return modelAndView;
    }
}

