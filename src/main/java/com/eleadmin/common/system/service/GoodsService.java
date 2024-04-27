package com.eleadmin.common.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.common.system.entity.Goods;
import com.eleadmin.common.system.param.GoodsParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2024-04-27 14:19:55
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Goods>
     */
    PageResult<Goods> pageRel(GoodsParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Goods>
     */
    List<Goods> listRel(GoodsParam param);

    /**
     * 根据id查询
     *
     * @param id 流水号
     * @return Goods
     */
    Goods getByIdRel(Integer id);

}
