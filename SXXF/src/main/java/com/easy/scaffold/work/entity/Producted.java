package com.easy.scaffold.work.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 成产批次表
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
public class Producted extends Model<Producted> {

    private static final long serialVersionUID = 1L;

    private String id;

    @TableField("workId")
    private String workid;

    /**
     * 生产批次
     */
    private String batch;

    /**
     * 生产物料
     */
    private String mater;

    /**
     * 生产品牌
     */
    private String brand;

    /**
     * 生产流程
     */
    private String process;

    @TableField("createDate")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdate;

    @TableField("createUser")
    private String createuser;

    @TableField("updateDate")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedate;

    @TableField("updateUser")
    private String updateuser;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getMater() {
        return mater;
    }

    public void setMater(String mater) {
        this.mater = mater;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Producted{" +
        "id=" + id +
        ", workid=" + workid +
        ", batch=" + batch +
        ", mater=" + mater +
        ", brand=" + brand +
        ", process=" + process +
        ", createdate=" + createdate +
        ", createuser=" + createuser +
        ", updatedate=" + updatedate +
        ", updateuser=" + updateuser +
        "}";
    }
}
