package com.depeexi.securitytest.jwt;

import com.depeexi.securitytest.po.Admins;
import com.depeexi.securitytest.po.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(Admins user){
        return new JwtUser(
                user.getId(),
                user.getState(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                mapToGrandAuthroties(user.getAuthorities()),
                user.getAexist()==1?true:false,
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrandAuthroties(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
