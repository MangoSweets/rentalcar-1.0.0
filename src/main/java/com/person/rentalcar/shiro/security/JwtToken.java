package com.person.rentalcar.shiro.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/4/5
 */
public class JwtToken implements AuthenticationToken {

    /**
     * 密钥
     */
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
