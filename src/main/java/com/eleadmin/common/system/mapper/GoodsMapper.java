package com.eleadmin.common.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.common.system.entity.Goods;
import com.eleadmin.common.system.param.GoodsParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2024-04-27 14:19:55
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Goods>
     */
    List<Goods> selectPageRel(@Param("page") IPage<Goods> page,
                             @Param("param") GoodsParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Goods> selectListRel(@Param("param") GoodsParam param);

}
