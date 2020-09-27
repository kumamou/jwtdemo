package com.depeexi.securitytest.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Admins implements Serializable {
    private Integer id;
    private String  username;
    private String password;
    private Integer aexist = 1;
    private Integer state;
    private String email;
    private Integer doid;
    private String by1;
    private Integer roleType;
    private Date lastPasswordResetDate;
    private List<Authority> authorities;
}
