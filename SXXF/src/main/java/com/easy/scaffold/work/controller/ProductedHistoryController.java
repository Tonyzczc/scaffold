package com.easy.scaffold.work.controller;

import com.easy.scaffold.common.pojo.Result;
import com.easy.scaffold.work.entity.Producted;
import com.easy.scaffold.work.entity.Work;
import com.easy.scaffold.work.service.IProductedService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:Zhangchi
 * @date:2021-01-23 上午9:35
 **/
@Controller
@RequestMapping("/work/productedHistory")
public class ProductedHistoryController {

    @Autowired
    private IProductedService productedService;

    @GetMapping("")
    public ModelAndView user(){
        return new ModelAndView("work/productedHistory");
    }

    @RequestMapping("productHistoryList")
    @ResponseBody
    public Result productHistoryList(String workId , Integer page, Integer rows){
        Page<Producted> pages = PageHelper.startPage(page, rows);
        return Result.of(new PageInfo(productedService.selectWorkIdHistory(workId)));
    }
}
