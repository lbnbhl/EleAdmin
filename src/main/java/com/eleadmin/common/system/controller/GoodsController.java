package com.eleadmin.common.system.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.common.system.service.GoodsService;
import com.eleadmin.common.system.entity.Goods;
import com.eleadmin.common.system.param.GoodsParam;
import com.eleadmin.common.core.web.ApiResult;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.BatchParam;
import com.eleadmin.common.core.annotation.OperationLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2024-04-27 14:19:55
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/system/goods")
public class GoodsController extends BaseController {
    @Resource
    private GoodsService goodsService;

    @PreAuthorize("hasAuthority('system:goods:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Goods>> page(GoodsParam param) {
        PageParam<Goods, GoodsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(goodsService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(goodsService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('system:goods:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<Goods>> list(GoodsParam param) {
        PageParam<Goods, GoodsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(goodsService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(goodsService.listRel(param));
    }

    @PreAuthorize("hasAuthority('system:goods:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Goods> get(@PathVariable("id") Integer id) {
        return success(goodsService.getById(id));
        // 使用关联查询
        //return success(goodsService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('system:goods:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody Goods goods) {
        if (goodsService.save(goods)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('system:goods:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody Goods goods) {
        if (goodsService.updateById(goods)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('system:goods:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (goodsService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @PreAuthorize("hasAuthority('system:goods:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Goods> list) {
        if (goodsService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('system:goods:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Goods> batchParam) {
        if (batchParam.update(goodsService, "ID")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('system:goods:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (goodsService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
