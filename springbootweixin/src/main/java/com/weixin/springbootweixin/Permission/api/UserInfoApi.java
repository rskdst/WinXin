package com.weixin.springbootweixin.Permission.api;

import com.weixin.springbootweixin.utils.Md5;
import com.weixin.springbootweixin.config.jwtConfig;
import com.weixin.springbootweixin.entity.RestApi;
import com.weixin.springbootweixin.config.JwtIgnore;
import com.weixin.springbootweixin.utils.jwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.weixin.springbootweixin.Permission.domain.UserInfo;
import com.weixin.springbootweixin.Permission.service.UserInfoService;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/api")
public class UserInfoApi {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private jwtConfig jwtConfig;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @JwtIgnore
    public RestApi<String> register(String nickname,Integer address,String phone,String password,String avatar)
    {
        Map<String,String> data= new HashMap<>();
        try {
            String md5Password = Md5.getMd5(password);
            UserInfo userinfo = new UserInfo();
            userinfo.setNickname(nickname);
            userinfo.setAddress(address);
            userinfo.setPhone(phone);
            userinfo.setPassword(md5Password);
            userinfo.setAvatar(avatar);
            int a = userInfoService.Register(userinfo);
            if(a == 1){
                return new RestApi<>(1,"","");
            }
            else{
                return new RestApi<>(1,"","");
            }
        } catch (Exception e){
            return new RestApi<>(0,"","");
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @JwtIgnore
    public RestApi<Object> login(HttpServletResponse response, String phone, String password)
    {

        UserInfo userinfo = userInfoService.SelectByPhone(phone);
        if (userinfo == null){
            return new RestApi<Object>(0,"","用户未创建");
        }else {
            String md5Password;
            try {
               md5Password  = Md5.getMd5(password);
            } catch (Exception e){
                md5Password = "";
            }
            if (md5Password.equals(userinfo.getPassword())){
                String token = jwtUtils.createJWT(phone,jwtConfig);
                // 将token放在响应头
                response.setHeader(jwtUtils.AUTH_HEADER_KEY, jwtUtils.TOKEN_PREFIX + token);
                // 将token响应给客户端
                Map<String,String> data= new HashMap<>();
                data.put("token",token);
                return new RestApi<Object>(1,data,"success");
            }else {
                return new RestApi<Object>(0,"","");
            }
        }

    }
}
