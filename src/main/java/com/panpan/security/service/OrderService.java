package com.panpan.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.panpan.security.entity.Order;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */
public interface OrderService extends IService<Order> {

    Object findByPage(Integer page,Integer limit,String param);

}
