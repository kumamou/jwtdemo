package com.depeexi.securitytest.service.impl;

import com.depeexi.securitytest.enujm.AuthorityNameEnum;
import com.depeexi.securitytest.jwt.JwtUserFactory;
import com.depeexi.securitytest.mapper.UserMapper;
import com.depeexi.securitytest.po.Admins;
import com.depeexi.securitytest.po.Authority;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2018-2020. All rights reserved.
 *
 * <desc>
 *      用户鉴权操作service实现类
 * </desc>
 *
 * @author Jiaqi.X
 * @date
 */
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * <desc>
     *      检测用户是否存在
     * </desc>
     *
     * @param username 用户名
     *
     * @return jwtUser
     * @throws UsernameNotFoundException 查询不到用户异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admins admins = this.userMapper.findByUserName(username);
        if(admins !=null) {
            Authority authority = new Authority();
            authority.setId(3);
            authority.setName(AuthorityNameEnum.getTypeEnum(admins.getRoleType().toString()));
            List<Authority> authorityList = new ArrayList<>();
            authorityList.add(authority);
            admins.setAuthorities(authorityList);
            return JwtUserFactory.create(admins);
        }else{
            throw new UsernameNotFoundException("NO USER FOUND WITH USERNAME"+username);
        }
    }

}
