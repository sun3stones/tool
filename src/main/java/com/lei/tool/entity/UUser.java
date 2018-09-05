package com.lei.tool.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "u_user")
public class UUser {
    @Id
    private Long id;

    /**
     * 用户昵称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 邮箱|登录帐号
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 1:有效，0:禁止登录
     */
    private Long status;

    @Column(name = "login_time")
    private Date loginTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户昵称
     *
     * @return user_name - 用户昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户昵称
     *
     * @param userName 用户昵称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取邮箱|登录帐号
     *
     * @return email - 邮箱|登录帐号
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱|登录帐号
     *
     * @param email 邮箱|登录帐号
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取1:有效，0:禁止登录
     *
     * @return status - 1:有效，0:禁止登录
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置1:有效，0:禁止登录
     *
     * @param status 1:有效，0:禁止登录
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * @return login_time
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}