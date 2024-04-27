package com.eleadmin.common.system.param;

import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 查询参数
 *
 * @author EleAdmin
 * @since 2024-04-27 14:19:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "GoodsParam对象", description = "查询参数")
public class GoodsParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流水号")
    @QueryField(type = QueryType.EQ)
    private Integer id;

    @ApiModelProperty(value = "商品编码")
    private String goodid;

    @ApiModelProperty(value = "商品名称")
    private String title;

    @ApiModelProperty(value = "类型")
    private String goodtype;

    @ApiModelProperty(value = "商品价格")
    private String createtime;

    @ApiModelProperty(value = "创建时间")
    private String creatorid;

    @ApiModelProperty(value = "创建人")
    private String changedate;

    private String changorid;

    @ApiModelProperty(value = "价格")
    @QueryField(type = QueryType.EQ)
    private BigDecimal price;

}
