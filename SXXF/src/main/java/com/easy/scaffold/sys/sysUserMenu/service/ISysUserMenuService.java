package com.easy.scaffold.sys.sysUserMenu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.scaffold.sys.sysUserMenu.entity.SysUserMenu;

/**
 * <p>
 * 用户菜单表 服务类
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public interface ISysUserMenuService extends IService<SysUserMenu> {

    boolean saveAllByUserId(String userId, String menuIdList);
}
