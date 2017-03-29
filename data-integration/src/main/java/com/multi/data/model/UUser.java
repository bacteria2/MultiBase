package com.multi.data.model;

import java.util.Date;

public class UUser {

    //0:禁止登录
    public static final Long _0 = 0L;
    //1:有效
    public static final Long _1 = 1L;

    private Long id;

    private String nickname;

    private String email;

    private String pswd;

    private Date createTime;

    private Date lastLoginTime;

    private Long status;

    public UUser(Long id, String nickname, String email, String pswd, Date createTime, Date lastLoginTime, Long status) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.pswd = pswd;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
    }

    public UUser(UUser user) {
        this(user.getId(),user.getNickname(),
                user.getEmail(),user.getPswd(),user.getCreateTime(),user.getLastLoginTime(),user.getStatus());
    }

    public UUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd == null ? null : pswd.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}