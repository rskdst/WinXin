package com.weixin.springbootweixin.Permission.domain;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String nickname; //昵称
    private int address; //地址
    private String phone; //手机号
    private String password; //密码
    private String avatar; //头像
}

