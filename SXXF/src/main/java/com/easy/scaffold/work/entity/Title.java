package com.easy.scaffold.work.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 字幕表
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
public class Title extends Model<Title> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
    private String id;

    @TableField("workId")
    private String workid;

    private String message;

    private Integer type;

    @TableField("createDate")
    private LocalDateTime createdate;

    @TableField("createUser")
    private String createuser;

    @TableField("updateDate")
    private LocalDateTime updatedate;

    @TableField("updateUser")
    private String updateuser;


    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public LocalDateTime getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(LocalDateTime updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Title{" +
        "workid=" + workid +
        ", message=" + message +
        ", type=" + type +
        ", createdate=" + createdate +
        ", createuser=" + createuser +
        ", updatedate=" + updatedate +
        ", updateuser=" + updateuser +
        "}";
    }
}
