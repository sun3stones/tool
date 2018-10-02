package com.lei.tool.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "project_task")
public class ProjectTask {
    @Id
    private Long id;

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
    private String docs;

    /**
     * 任务开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 任务截止期限
     */
    @Column(name = "end_time")
    private Date endTime;

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
     * @return docs - 任务附件
     */
    public String getDocs() {
        return docs;
    }

    /**
     * 设置任务附件
     *
     * @param docs 任务附件
     */
    public void setDocs(String docs) {
        this.docs = docs;
    }

    /**
     * 获取任务开始时间
     *
     * @return start_time - 任务开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置任务开始时间
     *
     * @param startTime 任务开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取任务截止期限
     *
     * @return end_time - 任务截止期限
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置任务截止期限
     *
     * @param endTime 任务截止期限
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}