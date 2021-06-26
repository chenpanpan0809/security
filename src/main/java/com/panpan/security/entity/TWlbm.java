package com.panpan.security.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * T_WLBM
 * @author 
 */
@Data
@TableName("T_WLBM")
public class TWlbm implements Serializable {
    @TableId("id")
    private Integer id;

    /**
     * 编码
     */
    private String bm;

    /**
     * 品名
     */
    private String name;

    /**
     * 规格
     */
    private String size;

    /**
     * 存货单位
     */
    private String unit;

    /**
     * 结存数量
     */
    private Integer jzsl;

    private static final long serialVersionUID = 1L;
}