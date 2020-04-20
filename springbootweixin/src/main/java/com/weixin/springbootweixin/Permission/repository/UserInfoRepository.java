package com.weixin.springbootweixin.Permission.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.weixin.springbootweixin.Permission.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoRepository {

    // 用户添加
    @Insert("insert into userinfo(nickname,address,phone,password,avatar) value(#{nickname},#{address},#{phone},#{password},#{avatar})")
    int addUser(UserInfo userInfo);

    // 查找指定用户
    @Select("select * from userinfo where phone=#{phone}")
    UserInfo SelectByPhone(@Param("phone") String phone);


}
