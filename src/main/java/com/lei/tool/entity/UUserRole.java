package com.lei.tool.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "u_user_role")
public class UUserRole implements Serializable {
    private static final long serialVersionUID = -7690338725271168229L;
    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 角色ID
     */
    private Long rid;

    /**
     * 获取用户ID
     *
     * @return uid - 用户ID
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置用户ID
     *
     * @param uid 用户ID
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取角色ID
     *
     * @return rid - 角色ID
     */
    public Long getRid() {
        return rid;
    }

    /**
     * 设置角色ID
     *
     * @param rid 角色ID
     */
    public void setRid(Long rid) {
        this.rid = rid;
    }
}