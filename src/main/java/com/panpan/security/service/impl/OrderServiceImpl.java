package com.panpan.security.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panpan.security.common.ResponseResult;
import com.panpan.security.entity.Order;
import com.panpan.security.mapper.OrderMapper;
import com.panpan.security.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


    @Override
    public ResponseResult<Order> findByPage(Integer page, Integer limit, String param) {
        Map paramMap = JSON.parseObject(param, Map.class);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.allEq(paramMap);
        Page<Order> pageObj = new Page<>(page, limit);
        IPage iPage = getBaseMapper().selectOrderPage(pageObj, wrapper);
        return  ResponseResult.page(0,"success",iPage.getTotal(),iPage.getRecords());
    }
}
