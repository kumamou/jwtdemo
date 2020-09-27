package com.depeexi.securitytest.po;

import com.depeexi.securitytest.enujm.AuthorityNameEnum;

import java.io.Serializable;

public class Authority implements Serializable {
    private Integer id;
    private AuthorityNameEnum name;

    public Authority() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorityNameEnum getName() {
        return name;
    }

    public void setName(AuthorityNameEnum name) {
        this.name = name;
    }
}
