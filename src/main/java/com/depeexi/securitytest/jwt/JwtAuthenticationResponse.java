package com.depeexi.securitytest.jwt;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.Serializable;
import java.security.MessageDigest;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2018-2020. All rights reserved.
 *
 * 响应对象
 *
 * @author Jiaqi.X
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 7741005964601421020L;

    private final String token;

    public JwtAuthenticationResponse(String token){
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }

}
