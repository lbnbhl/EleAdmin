package com.eleadmin.common.system.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2024-04-27 14:19:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流水号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品编码")
    @TableField("GoodID")
    private String goodid;

    @ApiModelProperty(value = "商品名称")
    @TableField("Title")
    private String title;

    @ApiModelProperty(value = "类型")
    @TableField("GoodType")
    private String goodtype;

    @ApiModelProperty(value = "商品价格")
    @TableField("CreateTime")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "创建时间")
    @TableField("CreatorID")
    private String creatorid;

    @ApiModelProperty(value = "创建人")
    @TableField("ChangeDate")
    private LocalDateTime changedate;

    @TableField("ChangorID")
    private String changorid;

    @ApiModelProperty(value = "价格")
    @TableField("Price")
    private BigDecimal price;

}
