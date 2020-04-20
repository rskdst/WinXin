package com.weixin.springbootweixin.Permission.service;

import com.weixin.springbootweixin.Permission.repository.UserInfoRepository;
import com.weixin.springbootweixin.Permission.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    //用户添加
    public Integer Register(UserInfo userinfo)
    {
        return userInfoRepository.addUser(userinfo);
    }

    //根据手机号判断用户是否存在
    public UserInfo SelectByPhone(String phone){
        UserInfo userinfo = userInfoRepository.SelectByPhone(phone);
        if(userinfo != null){
            System.out.println("用户存在");
        }else {
            return null;
        }
        return userinfo;
    }
}
