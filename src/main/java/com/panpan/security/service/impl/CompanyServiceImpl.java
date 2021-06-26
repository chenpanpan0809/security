package com.panpan.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panpan.security.entity.Company;
import com.panpan.security.mapper.CompanyMapper;
import com.panpan.security.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Override
    public List<Company> queryAllCompany() {
        return getBaseMapper().selectList(null);
    }

    @Override
    public Company getByCompany(String company) {
        QueryWrapper<Company> queryWrapper = new QueryWrapper<Company>();
        queryWrapper.eq("company",company);
        return getOne(queryWrapper);
    }
}
