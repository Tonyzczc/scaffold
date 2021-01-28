package com.easy.scaffold.sys.sysUser.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId
    private String userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 软删除标识，Y/N
     */
    private String valid;

    /**
     * 限制允许登录的IP集合
     */
    private String limitedIp;

    /**
     * 账号失效时间，超过时间将不能登录系统
     */
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiredTime;

    /**
     * 最近修改密码时间，超出时间间隔，提示用户修改密码
     */
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastChangePwdTime;

    /**
     * 是否允许账号同一个时刻多人在线，Y/N
     */
    private String limitMultiLogin;

    /**
     * 创建时间
     */
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
            "userId=" + userId +
            ", loginName=" + loginName +
            ", userName=" + userName +
            ", password=" + password +
            ", valid=" + valid +
            ", limitedIp=" + limitedIp +
            ", expiredTime=" + expiredTime +
            ", lastChangePwdTime=" + lastChangePwdTime +
            ", limitMultiLogin=" + limitMultiLogin +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
