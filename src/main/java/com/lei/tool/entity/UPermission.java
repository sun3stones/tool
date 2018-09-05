package com.lei.tool.entity;

import javax.persistence.*;

@Table(name = "u_permission")
public class UPermission {
    @Id
    private Long id;

    /**
     * url地址
     */
    private String url;

    /**
     * url描述
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否为菜单
     */
    @Column(name = "is_menu")
    private Integer isMenu;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 页面内容
     */
    private String content;

    /**
     * 父权限id
     */
    @Column(name = "parent_id")
    private Long parentId;

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
     * 获取url地址
     *
     * @return url - url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url地址
     *
     * @param url url地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取url描述
     *
     * @return name - url描述
     */
    public String getName() {
        return name;
    }

    /**
     * 设置url描述
     *
     * @param name url描述
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否为菜单
     *
     * @return is_menu - 是否为菜单
     */
    public Integer getIsMenu() {
        return isMenu;
    }

    /**
     * 设置是否为菜单
     *
     * @param isMenu 是否为菜单
     */
    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    /**
     * 获取级别
     *
     * @return level - 级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置级别
     *
     * @param level 级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取页面内容
     *
     * @return content - 页面内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置页面内容
     *
     * @param content 页面内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取父权限id
     *
     * @return parent_id - 父权限id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父权限id
     *
     * @param parentId 父权限id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}