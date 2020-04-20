package com.weixin.springbootweixin.utils;


import com.weixin.springbootweixin.entity.ExceptionApi;
import com.weixin.springbootweixin.config.jwtConfig;

import io.jsonwebtoken.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * jwt的生成及认证
 */

public class jwtUtils {


    public static final String AUTH_HEADER_KEY = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 解析jwt
     * @param jsonWebToken
     * @param Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String Security) {
        try {
            Claims claims = Jwts.parser()
//                    .setSigningKey(DatatypeConverter.parseBase64Binary(Security))
                    .setSigningKey(Security)
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (ExpiredJwtException  eje) {
            throw new ExceptionApi(-1,"", "token已过期");
        } catch (Exception e){
            System.out.println(e);
            throw new ExceptionApi(-1,"", "token已失效");
        }
    }

    /**
     * 构建jwt
     * @param jwtConfig
     * @return
     */
    public static String createJWT(String phone, jwtConfig jwtConfig) {
        try {
            // 使用HS512加密算法
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);

//            生成签名密钥
//            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtConfig.getSecret());
//            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            //添加构成JWT的参数
            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                    // 可以将基本不重要的对象信息放到claims
                    .claim("phone", phone)
                    .setIssuedAt(new Date())        // 是一个时间戳，代表这个JWT的签发时间；
                    .setAudience(jwtConfig.getIss())          // 代表这个JWT的接收对象；
                    .signWith(signatureAlgorithm, jwtConfig.getSecret());
            //添加Token过期时间
            int TTLMillis = jwtConfig.getExpiresSecond();
            if (TTLMillis >= 0) {
                long expMillis = nowMillis + TTLMillis;
                Date exp = new Date(expMillis);
                builder.setExpiration(exp)  // 是一个时间戳，代表这个JWT的过期时间；
                        .setNotBefore(now); // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
            }

            //生成JWT
            return builder.compact();
        } catch (Exception e) {
            throw new ExceptionApi(-1,"","token生成失败");
        }
    }

    /**
     * 从token中获取手机号码
     * @param token
     * @param Security
     * @return
     */
    public static String getPhone(String token, String Security){
        Claims claims= parseJWT(token, Security);
        return (String) claims.get("phone");
    }

    /**
     * 是否已过期
     * @param token
     * @param Security
     * @return
     */
    public static boolean isExpiration(String token, String Security) {
        return parseJWT(token, Security).getExpiration().before(new Date());
    }
}