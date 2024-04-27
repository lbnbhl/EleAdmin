package com.eleadmin.common.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.common.system.mapper.GoodsMapper;
import com.eleadmin.common.system.service.GoodsService;
import com.eleadmin.common.system.entity.Goods;
import com.eleadmin.common.system.param.GoodsParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2024-04-27 14:19:55
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Override
    public PageResult<Goods> pageRel(GoodsParam param) {
        PageParam<Goods, GoodsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Goods> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Goods> listRel(GoodsParam param) {
        List<Goods> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Goods, GoodsParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Goods getByIdRel(Integer id) {
        GoodsParam param = new GoodsParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
