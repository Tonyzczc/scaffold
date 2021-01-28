package com.easy.scaffold.sys.sysAuthority.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统权限表
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public class SysAuthority extends Model<SysAuthority> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId
    private String authorityId;

    /**
     * 权限名称，ROLE_开头，全大写
     */
    private String authorityName;

    /**
     * 权限描述
     */
    private String authorityRemark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 权限内容，可访问的url，多个时用,隔开
     */
    private String authorityContent;

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }
    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
    public String getAuthorityRemark() {
        return authorityRemark;
    }

    public void setAuthorityRemark(String authorityRemark) {
        this.authorityRemark = authorityRemark;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public String getAuthorityContent() {
        return authorityContent;
    }

    public void setAuthorityContent(String authorityContent) {
        this.authorityContent = authorityContent;
    }

    @Override
    protected Serializable pkVal() {
        return this.authorityId;
    }

    @Override
    public String toString() {
        return "SysAuthority{" +
            "authorityId=" + authorityId +
            ", authorityName=" + authorityName +
            ", authorityRemark=" + authorityRemark +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", authorityContent=" + authorityContent +
        "}";
    }
}
