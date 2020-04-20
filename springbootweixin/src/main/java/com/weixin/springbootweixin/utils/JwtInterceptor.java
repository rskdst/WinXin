package com.weixin.springbootweixin.utils;

import com.weixin.springbootweixin.entity.ExceptionApi;
import com.weixin.springbootweixin.config.JwtIgnore;
import com.weixin.springbootweixin.config.JwtConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token验证拦截器
 */
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 获取请求头信息authorization信息
        final String authHeader = request.getHeader(jwtUtils.AUTH_HEADER_KEY);

        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(jwtUtils.TOKEN_PREFIX)) {
            throw new ExceptionApi(-1,"", "请求头获取失败");
        }

        // 获取token
        final String token = authHeader.substring(7);

        if(jwtConfig == null){
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            jwtConfig = (JwtConfig) factory.getBean("JwtConfig");
        }

        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        jwtUtils.parseJWT(token, jwtConfig.getSecret());

        return true;
    }

}