package com.easy.scaffold.sys.sysUserMenu.controller;

import com.easy.scaffold.common.pojo.Result;
import com.easy.scaffold.config.annotation.Decrypt;
import com.easy.scaffold.config.annotation.Encrypt;
import com.easy.scaffold.sys.sysMenu.entity.SysMenu;
import com.easy.scaffold.sys.sysMenu.service.ISysMenuService;
import com.easy.scaffold.sys.sysUserMenu.entity.SysUserMenu;
import com.easy.scaffold.sys.sysUserMenu.service.ISysUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/sysUserMenu/")
public class SysUserMenuController  {
    @Autowired
    private ISysUserMenuService sysUserMenuService;
    @Autowired
    private ISysMenuService sysMenuService;

    @PostMapping("findUserMenuAndAllSysMenuByUserId")
    @Decrypt
    @Encrypt
    public Result<Map<String,Object>> findUserMenuAndAllSysMenuByUserId(String userId){
        HashMap<String, Object> map = new HashMap<>();
        List<SysMenu> userSysMenuVoList = sysMenuService.findByUserId(userId);
        map.put("userSysMenuVoList",userSysMenuVoList);
        List<SysMenu> sysMenuVoList = sysMenuService.listByTier(new SysMenu());
        map.put("sysMenuVoList",sysMenuVoList);
        return Result.of(map);
    }

    @PostMapping("saveAllByUserId")
    @Decrypt
    @Encrypt
    public Result<Boolean> saveAllByUserId(String userId , String menuIdList){
        return Result.of(sysUserMenuService.saveAllByUserId( userId, menuIdList));
    }
}
