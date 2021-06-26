package com.panpan.security.controller;


import com.alibaba.fastjson.JSON;

import com.panpan.security.common.ResponseResult;
import com.panpan.security.entity.Company;
import com.panpan.security.entity.Order;
import com.panpan.security.service.CompanyService;
import com.panpan.security.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author panpan
 * @since 2021-01-16
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/orderPage")
    public String orderPage(){
        return "order/order-page";
    }

    @ResponseBody
    @GetMapping("/orderPageData")
    public Object orderPageData(Integer page,Integer limit,String param){
        return  orderService.findByPage(page, limit, param);
    }

    @GetMapping("/input")
    public String input(Model model, String id){
        Order order= orderService.getById(id);
        if (order == null){
            order = new Order();
        }else {
            Company company = companyService.getById(order.getCompanyId());
            order.setCompany(company.getCompany());
        }
        model.addAttribute("order",order);
        return "order/input";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseResult save(String param, HttpServletRequest request){
        Order order  = JSON.parseObject(param, Order.class);
        if (order ==null){
            ResponseResult<Object> objectResultData = new ResponseResult<>();
            objectResultData.setCode(300);
            objectResultData.setMsg("数据填写有误");
            return objectResultData;
        }
        orderService.saveOrUpdate(order);
        String company = order.getCompany();
        Integer companyId = order.getCompanyId();
        Company companyByIdVo = companyService.getById(companyId);
        Company byCompany = companyService.getByCompany(company);
        if (companyByIdVo != null){
            companyByIdVo.setCompany(company);
            companyService.updateById(companyByIdVo);
        }
        if (companyByIdVo == null && byCompany == null){
            Company saveVo = new Company();
            saveVo.setCompany(company);
            companyService.save(saveVo);
        }
        ResponseResult<Object> objectResultData = new ResponseResult<>();
        objectResultData.setCode(0);
        objectResultData.setMsg("操作成功");
        return objectResultData;
    }

}
