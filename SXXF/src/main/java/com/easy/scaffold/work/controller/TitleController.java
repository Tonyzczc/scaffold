package com.easy.scaffold.work.controller;


import com.easy.scaffold.common.pojo.Result;
import com.easy.scaffold.util.DateUtil;
import com.easy.scaffold.util.SecurityUtil;
import com.easy.scaffold.work.entity.Title;
import com.easy.scaffold.work.entity.Work;
import com.easy.scaffold.work.service.ITitleService;
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

import java.sql.ResultSet;
import java.util.Date;

/**
 * <p>
 * 字幕表 前端控制器
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
@Controller
@RequestMapping("/work/title")
public class TitleController {

    @Autowired
    private ITitleService titleService;


    @GetMapping("")
    public ModelAndView user(){
        return new ModelAndView("work/title");
    }

    @RequestMapping("titleList")
    @ResponseBody
    public Result workerList(Integer page, Integer rows){
        Page<Title> pages = PageHelper.startPage(page, rows);
        return  Result.of(new PageInfo(titleService.list()));
    }

    @RequestMapping("save")
    @ResponseBody
    public Result save(Title title){
        if(StringUtils.isNotBlank(title.getId())){
            return Result.of(titleService.updateById(title));
        }
        title.setWorkid("0");
        User loginUser = SecurityUtil.getLoginUser();
        title.setUpdateuser(loginUser.getUsername());
        title.setUpdatedate(DateUtil.asLocalDateTime(new Date()));
        title.setCreateuser(loginUser.getUsername());
        title.setCreatedate(DateUtil.asLocalDateTime(new Date()));
        return Result.of(titleService.save(title));
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") String id){
        return Result.of(titleService.removeById(id));
    }
}

