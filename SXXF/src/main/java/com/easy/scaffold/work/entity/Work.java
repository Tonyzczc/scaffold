package com.easy.scaffold.work.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 车间管理
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
public class Work extends Model<Work> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
    private String id;

    /**
     * 车间名称
     */
    private String name;

    /**
     * 车间地址
     */
    private String address;

    /**
     * 车间门号
     */
    private String number;

    @TableField("createDate")
    private LocalDateTime createdate;

    @TableField("createUser")
    private String createuser;

    @TableField("updateDate")
    private LocalDateTime updatedate;

    @TableField("updateUser")
    private String updateuser;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        return "Work{" +
        "id=" + id +
        ", name=" + name +
        ", address=" + address +
        ", number=" + number +
        ", createdate=" + createdate +
        ", createuser=" + createuser +
        ", updatedate=" + updatedate +
        ", updateuser=" + updateuser +
        "}";
    }
}
