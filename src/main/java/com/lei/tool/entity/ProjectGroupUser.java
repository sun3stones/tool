package com.lei.tool.entity;

import javax.persistence.*;

@Table(name = "project_group_user")
public class ProjectGroupUser {
    /**
     * 项目组id
     */
    private Long gid;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 是否为项目管理员
     */
    @Column(name = "is_admin")
    private Integer isAdmin;

    /**
     * 获取项目组id
     *
     * @return gid - 项目组id
     */
    public Long getGid() {
        return gid;
    }

    /**
     * 设置项目组id
     *
     * @param gid 项目组id
     */
    public void setGid(Long gid) {
        this.gid = gid;
    }

    /**
     * 获取用户id
     *
     * @return uid - 用户id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置用户id
     *
     * @param uid 用户id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取是否为项目管理员
     *
     * @return is_admin - 是否为项目管理员
     */
    public Integer getIsAdmin() {
        return isAdmin;
    }

    /**
     * 设置是否为项目管理员
     *
     * @param isAdmin 是否为项目管理员
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}