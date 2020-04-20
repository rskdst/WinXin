package com.weixin.springbootweixin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 */
@Data
@ConfigurationProperties(prefix = "jwtconfig")
@Component
public class jwtConfig {
    private String Secret;
    private String iss;
    private int expiresSecond;
}
