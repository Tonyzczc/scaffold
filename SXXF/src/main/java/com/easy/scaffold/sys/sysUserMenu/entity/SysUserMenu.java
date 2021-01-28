package com.easy.scaffold.sys.sysUserMenu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户菜单表
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public class SysUserMenu extends Model<SysUserMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户菜单表id
     */
    @TableId
    private String userMenuId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public String getUserMenuId() {
        return userMenuId;
    }

    public void setUserMenuId(String userMenuId) {
        this.userMenuId = userMenuId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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
        return this.userMenuId;
    }

    @Override
    public String toString() {
        return "SysUserMenu{" +
            "userMenuId=" + userMenuId +
            ", userId=" + userId +
            ", menuId=" + menuId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
