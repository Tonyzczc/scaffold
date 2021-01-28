package com.easy.scaffold.work.dao;

import com.easy.scaffold.work.entity.Producted;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 成产批次表 Mapper 接口
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
public interface ProductedMapper extends BaseMapper<Producted> {

    /**
     * workId查询
     * @param workId
     * @return
     */
    Producted selectWorkId(String workId);

    /**
     * 历史配置
     * @param workId
     * @return
     */
    List<Producted> selectWorkIdHistory(String workId);
}
