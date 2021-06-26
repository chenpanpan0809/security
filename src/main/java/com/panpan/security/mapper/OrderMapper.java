package com.panpan.security.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.panpan.security.entity.Order;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */
public interface OrderMapper extends BaseMapper<Order> {

    IPage selectOrderPage(IPage<Order> page,  Wrapper<Order> queryWrapper);

}
