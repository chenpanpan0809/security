package com.panpan.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */

@Data
@TableName("T_ORDER")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 下单日期
     */
    @TableField("order_time")
    private LocalDateTime orderTime;

    /**
     * 物品名称
     */
    @TableField("item_name")
    private String itemName;

    /**
     * 型号
     */
    @TableField("item_type")
    private String itemType;

    /**
     * 单价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 数量
     */
    @TableField("num")
    private String num;

    /**
     * 单位
     */
    @TableField("danwei")
    private String danwei;

    /**
     * 编码
     */
    @TableField("bh")
    private String bh;

    /**
     * 到货日期
     */
    @TableField("dhrq")
    private LocalDateTime dhrq;

    /**
     * 入库日期
     */
    @TableField("rkrq")
    private LocalDateTime rkrq;

    @TableField("bz")
    private String bz;

    private transient String company;

    private Integer  companyId;
}
