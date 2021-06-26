package com.panpan.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */
@TableName("T_METRIAL_TYPE")
public class MetrialType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("metrial_id")
    private Integer metrialId;

    @TableField("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMetrialId() {
        return metrialId;
    }

    public void setMetrialId(Integer metrialId) {
        this.metrialId = metrialId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MetrialType{" +
            "id=" + id +
            ", metrialId=" + metrialId +
            ", name=" + name +
        "}";
    }
}
