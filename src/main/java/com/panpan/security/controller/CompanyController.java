package com.panpan.security.controller;



import com.panpan.security.entity.Company;
import com.panpan.security.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/queryAllCompany")
    public List<Company> queryAllCompany(){
       return companyService.queryAllCompany();
    }

}
