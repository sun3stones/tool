package com.lei.tool.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "u_role")
public class URole implements Serializable {
    private static final long serialVersionUID = 6380753587364475230L;
    @Id
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色等级
     */
    private Integer level;

    /**
     * 角色类型
     */
    private String type;

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
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色等级
     *
     * @return level - 角色等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置角色等级
     *
     * @param level 角色等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取角色类型
     *
     * @return type - 角色类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置角色类型
     *
     * @param type 角色类型
     */
    public void setType(String type) {
        this.type = type;
    }
}