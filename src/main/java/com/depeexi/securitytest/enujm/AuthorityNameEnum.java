package com.depeexi.securitytest.enujm;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *<desc>
 *      角色枚举类
 *</desc>
 *
 * @author Jiaqi.X
 */
public enum AuthorityNameEnum {
    /**
     * 管理员
     */
    ROLE_ADMIN("管理员", "1"),
    /**
     * 用户
     */
    ROLE_USER("用户", "2");

    /**
     * 描述
     */
    private String description;
    /**
     * 类型
     */
    private String type;

    /**
     * <desc>
     * 构造方法
     * </desc>
     *
     * @param role s
     * @param user s
     */
    private AuthorityNameEnum(String role, String user) {
        this.description = role;
        this.type = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    /**
     * <desc>
     *      转换list
     * </desc>>
     *
     * @return
     * @createTime 2020/9/23
     */
    public static List toList() {
        List list = Lists.newArrayList();
        for (AuthorityNameEnum authorityNameEnum : AuthorityNameEnum.values()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", authorityNameEnum.getType());
            map.put("description", authorityNameEnum.getDescription());
            list.add(map);
        }
        return list;
    }

    /**
     * <desc>
     *      根据type获取枚举类
     * </desc>
     *
     * @return AuthorityNameEnum
     */
    public static AuthorityNameEnum getTypeEnum(String type){
        for (AuthorityNameEnum authorityNameEnum : AuthorityNameEnum.values()) {
            if(type.equals(authorityNameEnum.getType())){
                return authorityNameEnum;
            }
        }
        return null;
    }
}
