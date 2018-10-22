package com.lei.tool.dto;

import java.util.Date;

public class TaskDto {

        private Long id;
        private String userName;
        private String projectName;

        private Date time;

        /**
         * 项目id
         */
        private Long pid;

        /**
         * 所属用户id
         */
        private Long uid;

        /**
         * 任务名称
         */
        private String taskName;

        /**
         * 任务类型（1大需求；2小需求；3bug）
         */
        private Integer taskType;

        /**
         * 任务类型（0待审核；1待处理；2处理完成待测；3测试中；4测试完成；5已上线；6挂起；7作废）
         */
        private Integer taskStatus;

        /**
         * 父任务id
         */
        private Long parentId;

        /**
         * 任务描述
         */
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
        private Date startTime;

        /**
         * 任务截止期限
         */
        private Date endTime;

        /**
         * 更新时间
         */
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        /**
         * 获取项目id
         *
         * @return pid - 项目id
         */
        public Long getPid() {
            return pid;
        }

        /**
         * 设置项目id
         *
         * @param pid 项目id
         */
        public void setPid(Long pid) {
            this.pid = pid;
        }

        /**
         * 获取所属用户id
         *
         * @return uid - 所属用户id
         */
        public Long getUid() {
            return uid;
        }

        /**
         * 设置所属用户id
         *
         * @param uid 所属用户id
         */
        public void setUid(Long uid) {
            this.uid = uid;
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
         * 获取任务类型（0待审核；1待处理；2处理完成待测；3测试中；4测试完成；5已上线；6挂起；7作废）
         *
         * @return task_status - 任务类型（0待审核；1待处理；2处理完成待测；3测试中；4测试完成；5已上线；6挂起；7作废）
         */
        public Integer getTaskStatus() {
            return taskStatus;
        }

        /**
         * 设置任务类型（0待审核；1待处理；2处理完成待测；3测试中；4测试完成；5已上线；6挂起；7作废）
         *
         * @param taskStatus 任务类型（0待审核；1待处理；2处理完成待测；3测试中；4测试完成；5已上线；6挂起；7作废）
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


        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }
}
