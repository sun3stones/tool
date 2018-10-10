package com.lei.tool.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "project_group")
public class ProjectGroup {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 项目组编号
     */
    @Column(name = "project_no")
    private String projectNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 项目建立时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

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
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取项目组编号
     *
     * @return project_no - 项目组编号
     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * 设置项目组编号
     *
     * @param projectNo 项目组编号
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取项目建立时间
     *
     * @return create_time - 项目建立时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置项目建立时间
     *
     * @param createTime 项目建立时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}