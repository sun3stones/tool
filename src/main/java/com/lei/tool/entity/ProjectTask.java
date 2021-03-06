package com.lei.tool.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;
import javax.persistence.*;

@Table(name = "project_task")
public class ProjectTask implements Serializable {
    private static final long serialVersionUID = 1560625530288771415L;
    @Id
    private Long id;

    /**
     * 所属项目id
     */
    private Long pid;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 任务编号
     */
    @Column(name = "task_no")
    private String taskNo;

    /**
     * 任务名称
     */
    @Column(name = "task_name")
    private String taskName;

    /**
     * 任务类型（1大需求；2小需求；3bug）
     */
    @Column(name = "task_type")
    private Integer taskType;

    /**
     * 任务类型（0待审核；1待处理；2处理完成待测；3测试完成；4已上线；5挂起；6作废）
     */
    @Column(name = "task_status")
    private Integer taskStatus;

    /**
     * 父任务id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 任务描述
     */
    @Column(name = "task_remark")
    private String taskRemark;

    /**
     * 任务图片
     */
    private String images;

    /**
     * 任务附件
     */
    private String files;

    /**
     * 任务开始时间
     */
    @Column(name = "start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    /**
     * 任务截止期限
     */
    @Column(name = "end_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    /**
     * 创建人
     */
    @Column(name = "create_name")
    private String createName;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date updateTime;

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
     * 获取所属项目id
     *
     * @return pid - 所属项目id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置所属项目id
     *
     * @param pid 所属项目id
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取任务编号
     *
     * @return task_no - 任务编号
     */
    public String getTaskNo() {
        return taskNo;
    }

    /**
     * 设置任务编号
     *
     * @param taskNo 任务编号
     */
    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * 获取任务名称
     *
     * @return task_name - 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名称
     *
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 获取任务类型（1大需求；2小需求；3bug）
     *
     * @return task_type - 任务类型（1大需求；2小需求；3bug）
     */
    public Integer getTaskType() {
        return taskType;
    }

    /**
     * 设置任务类型（1大需求；2小需求；3bug）
     *
     * @param taskType 任务类型（1大需求；2小需求；3bug）
     */
    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    /**
     * 获取任务类型（0待审核；1待处理；2处理完成待测；3测试完成；4已上线；5挂起；6作废）
     *
     * @return task_status - 任务类型（0待审核；1待处理；2处理完成待测；3测试完成；4已上线；5挂起；6作废）
     */
    public Integer getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置任务类型（0待审核；1待处理；2处理完成待测；3测试完成；4已上线；5挂起；6作废）
     *
     * @param taskStatus 任务类型（0待审核；1待处理；2处理完成待测；3测试完成；4已上线；5挂起；6作废）
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取父任务id
     *
     * @return parent_id - 父任务id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父任务id
     *
     * @param parentId 父任务id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取任务描述
     *
     * @return task_remark - 任务描述
     */
    public String getTaskRemark() {
        return taskRemark;
    }

    /**
     * 设置任务描述
     *
     * @param taskRemark 任务描述
     */
    public void setTaskRemark(String taskRemark) {
        this.taskRemark = taskRemark;
    }

    /**
     * 获取任务图片
     *
     * @return images - 任务图片
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置任务图片
     *
     * @param images 任务图片
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取任务附件
     *
     * @return files - 任务附件
     */
    public String getFiles() {
        return files;
    }

    /**
     * 设置任务附件
     *
     * @param files 任务附件
     */
    public void setFiles(String files) {
        this.files = files;
    }

    /**
     * 获取任务开始时间
     *
     * @return start_date - 任务开始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置任务开始时间
     *
     * @param startDate 任务开始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取任务截止期限
     *
     * @return end_date - 任务截止期限
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置任务截止期限
     *
     * @param endDate 任务截止期限
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取创建人
     *
     * @return create_name - 创建人
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置创建人
     *
     * @param createName 创建人
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}