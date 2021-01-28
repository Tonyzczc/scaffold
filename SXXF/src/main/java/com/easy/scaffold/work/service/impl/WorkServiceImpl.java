package com.easy.scaffold.work.service.impl;

import com.easy.scaffold.work.entity.Work;
import com.easy.scaffold.work.dao.WorkMapper;
import com.easy.scaffold.work.service.IWorkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车间管理 服务实现类
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements IWorkService {

}
