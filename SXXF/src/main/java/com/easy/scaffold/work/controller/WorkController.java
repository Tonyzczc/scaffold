package com.easy.scaffold.work.controller;


import com.easy.scaffold.common.pojo.Result;
import com.easy.scaffold.sys.sysUser.entity.SysUser;
import com.easy.scaffold.util.DateUtil;
import com.easy.scaffold.util.SecurityUtil;
import com.easy.scaffold.util.SysSettingUtil;
import com.easy.scaffold.work.entity.Work;
import com.easy.scaffold.work.service.IWorkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * <p>
 * 车间管理 前端控制器
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private IWorkService workService;

    @GetMapping("")
    public ModelAndView user(){
        return new ModelAndView("work/work");
    }

    @RequestMapping("workerList")
    @ResponseBody
    public Result workerList(Integer page, Integer rows){
        Page<Work> pages = PageHelper.startPage(page, rows);
        return  Result.of(new PageInfo(workService.list()));
    }

    @RequestMapping("save")
    @ResponseBody
    public Result save(Work work){
        User loginUser = SecurityUtil.getLoginUser();
        work.setUpdateuser(loginUser.getUsername());
        work.setUpdatedate(DateUtil.asLocalDateTime(new Date()));
        if(StringUtils.isNotBlank(work.getId())){
            return Result.of(workService.updateById(work));
        }
        work.setCreateuser(loginUser.getUsername());
        work.setCreatedate(DateUtil.asLocalDateTime(new Date()));
        return Result.of(workService.save(work));
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") String id){
        return Result.of(workService.removeById(id));
    }


}

