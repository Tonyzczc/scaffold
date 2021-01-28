package com.easy.scaffold.work.service.impl;

import com.easy.scaffold.work.entity.Title;
import com.easy.scaffold.work.dao.TitleMapper;
import com.easy.scaffold.work.service.ITitleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字幕表 服务实现类
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
@Service
public class TitleServiceImpl extends ServiceImpl<TitleMapper, Title> implements ITitleService {

}
