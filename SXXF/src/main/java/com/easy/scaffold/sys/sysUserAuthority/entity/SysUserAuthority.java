package com.easy.scaffold.sys.sysUserAuthority.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户权限表
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public class SysUserAuthority extends Model<SysUserAuthority> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户权限表id
     */
    @TableId
    private String userAuthorityId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 权限id
     */
    private String authorityId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public String getUserAuthorityId() {
        return userAuthorityId;
    }

    public void setUserAuthorityId(String userAuthorityId) {
        this.userAuthorityId = userAuthorityId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
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

    @Override
    protected Serializable pkVal() {
        return this.userAuthorityId;
    }

    @Override
    public String toString() {
        return "SysUserAuthority{" +
            "userAuthorityId=" + userAuthorityId +
            ", userId=" + userId +
            ", authorityId=" + authorityId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
