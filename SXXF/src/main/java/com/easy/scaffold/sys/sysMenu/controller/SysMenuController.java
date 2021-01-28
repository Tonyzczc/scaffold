package com.easy.scaffold.sys.sysMenu.controller;


import com.easy.scaffold.common.pojo.Result;
import com.easy.scaffold.config.annotation.Decrypt;
import com.easy.scaffold.config.annotation.Encrypt;
import com.easy.scaffold.sys.sysMenu.entity.SysMenu;
import com.easy.scaffold.sys.sysMenu.service.ISysMenuService;
import com.easy.scaffold.util.DateUtil;
import com.easy.scaffold.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sys/sysMenu/")
public class SysMenuController{
    @Autowired
    private ISysMenuService sysMenuService;

    @GetMapping("menu")
    public ModelAndView menu(){
        return new ModelAndView("sys/menu/menu");
    }

    /**
     * 分层级
     */
    @PostMapping("listByTier")
    @Decrypt
    @Encrypt
    public Result<List<SysMenu>> listByTier(SysMenu entityVo) {
        return Result.of(sysMenuService.listByTier(entityVo));
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable("id") String id){
        return Result.of(sysMenuService.removeById(id));
    }

    @PostMapping("save")
    public Result save(SysMenu sysMenu){
        if(StringUtils.isNotEmpty(sysMenu.getMenuId())){
            return Result.of(sysMenuService.updateById(sysMenu));
        }
        sysMenu.setMenuId(UUIDUtil.getUUID());
        sysMenu.setCreateTime(DateUtil.asLocalDateTime(new Date()));
        sysMenu.setUpdateTime(DateUtil.asLocalDateTime(new Date()));
        return Result.of(sysMenuService.save(sysMenu));
    }



}
