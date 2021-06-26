package com.panpan.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.panpan.security.entity.Company;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */
public interface CompanyService extends IService<Company> {

    List<Company> queryAllCompany();

    Company getByCompany(String company);

}
