package com.sf.multimodal.domain;

import java.io.Serializable;

/**
 * Created by Jacky on 2019/1/7 17:12.
 */
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private String password;
    private String userFullName;
    private Integer status;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
