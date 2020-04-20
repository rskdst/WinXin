package com.weixin.springbootweixin.utils;

import org.springframework.util.DigestUtils;
import java.io.UnsupportedEncodingException;

/**
 * MD5加密
 */

public class Md5
{
    public static String getMd5(String str) throws UnsupportedEncodingException {
        byte[] textByte = str.getBytes("UTF-8");

        return DigestUtils.md5DigestAsHex(textByte).toString();
    }
}
