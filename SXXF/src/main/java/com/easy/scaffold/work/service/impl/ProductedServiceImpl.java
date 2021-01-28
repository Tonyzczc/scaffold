package com.easy.scaffold.work.service.impl;

import com.easy.scaffold.work.entity.Producted;
import com.easy.scaffold.work.dao.ProductedMapper;
import com.easy.scaffold.work.service.IProductedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 成产批次表 服务实现类
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
@Service
public class ProductedServiceImpl extends ServiceImpl<ProductedMapper, Producted> implements IProductedService {

    @Resource
    private ProductedMapper productedMapper;

    @Override
    public Producted selectWorkId(String workId) {
        return productedMapper.selectWorkId(workId);
    }

    @Override
    public List<Producted> selectWorkIdHistory(String workId) {
        return productedMapper.selectWorkIdHistory(workId);
    }
}
