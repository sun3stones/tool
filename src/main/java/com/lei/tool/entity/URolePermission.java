package com.lei.tool.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "u_role_permission")
public class URolePermission implements Serializable {
    private static final long serialVersionUID = -3834623107857963361L;
    /**
     * 角色ID
     */
    private Long rid;

    /**
     * 权限ID
     */
    private Long pid;

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

    /**
     * 获取权限ID
     *
     * @return pid - 权限ID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置权限ID
     *
     * @param pid 权限ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }
}