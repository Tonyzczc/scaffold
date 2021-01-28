package com.easy.scaffold.work.service;

import com.easy.scaffold.work.entity.Producted;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 成产批次表 服务类
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
public interface IProductedService extends IService<Producted> {

    Producted selectWorkId(String workId);

    List<Producted> selectWorkIdHistory(String workId);
}
