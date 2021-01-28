package com.easy.scaffold.sys.sysSetting.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统设置表
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSetting extends Model<SysSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId
    private String id;

    /**
     * 系统名称
     */
    private String sysName;

    /**
     * 系统logo图标
     */
    private String sysLogo;

    /**
     * 系统底部信息
     */
    private String sysBottomText;

    /**
     * 系统公告
     */
    private String sysNoticeText;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户管理：初始、重置密码
     */
    private String userInitPassword;

    /**
     * 系统颜色
     */
    private String sysColor;

    /**
     * API加密 Y/N
     */
    private String sysApiEncrypt;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysSetting{" +
            "id=" + id +
            ", sysName=" + sysName +
            ", sysLogo=" + sysLogo +
            ", sysBottomText=" + sysBottomText +
            ", sysNoticeText=" + sysNoticeText +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", userInitPassword=" + userInitPassword +
            ", sysColor=" + sysColor +
            ", sysApiEncrypt=" + sysApiEncrypt +
        "}";
    }
}
