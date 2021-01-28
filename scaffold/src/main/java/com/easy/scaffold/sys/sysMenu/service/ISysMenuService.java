package com.easy.scaffold.sys.sysMenu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.scaffold.sys.sysMenu.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 系统菜单表 服务类
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> findByUserId(String userId);

    List<SysMenu> listByTier(SysMenu sysMenu);
}
