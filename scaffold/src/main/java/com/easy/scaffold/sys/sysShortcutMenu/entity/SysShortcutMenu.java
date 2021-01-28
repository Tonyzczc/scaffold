package com.easy.scaffold.sys.sysShortcutMenu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户快捷菜单表
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public class SysShortcutMenu extends Model<SysShortcutMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户快捷菜单id
     */
    @TableId
    private String shortcutMenuId;

    /**
     * 用户快捷菜单名称
     */
    private String shortcutMenuName;

    /**
     * 用户快捷菜单路径
     */
    private String shortcutMenuPath;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 上级id
     */
    private String shortcutMenuParentId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public String getShortcutMenuId() {
        return shortcutMenuId;
    }

    public void setShortcutMenuId(String shortcutMenuId) {
        this.shortcutMenuId = shortcutMenuId;
    }
    public String getShortcutMenuName() {
        return shortcutMenuName;
    }

    public void setShortcutMenuName(String shortcutMenuName) {
        this.shortcutMenuName = shortcutMenuName;
    }
    public String getShortcutMenuPath() {
        return shortcutMenuPath;
    }

    public void setShortcutMenuPath(String shortcutMenuPath) {
        this.shortcutMenuPath = shortcutMenuPath;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getShortcutMenuParentId() {
        return shortcutMenuParentId;
    }

    public void setShortcutMenuParentId(String shortcutMenuParentId) {
        this.shortcutMenuParentId = shortcutMenuParentId;
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
        return this.shortcutMenuId;
    }

    @Override
    public String toString() {
        return "SysShortcutMenu{" +
            "shortcutMenuId=" + shortcutMenuId +
            ", shortcutMenuName=" + shortcutMenuName +
            ", shortcutMenuPath=" + shortcutMenuPath +
            ", userId=" + userId +
            ", shortcutMenuParentId=" + shortcutMenuParentId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
