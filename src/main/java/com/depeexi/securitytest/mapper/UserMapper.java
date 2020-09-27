package com.depeexi.securitytest.mapper;

import com.depeexi.securitytest.po.Admins;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <desc>
 *      用户数据访问接口
 * </desc>
 *
 * @author Jiaqi.X
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * <desc>
     *      根据用户名查询用户
     * </desc>
     *
     * @return String
     */
    Admins findByUserName(@Param("userName") String userName);
}
