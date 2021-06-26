package com.panpan.security.service.impl;

import com.baomidou.mybatisplus.core.injector.methods.SelectPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panpan.security.common.ResponseResult;
import com.panpan.security.entity.TWlbm;
import com.panpan.security.mapper.TWlbmMapper;
import com.panpan.security.service.WlbmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WlbmServiceImpl extends ServiceImpl<TWlbmMapper, TWlbm> implements WlbmService {




    @Override
    public ResponseResult getPage(Integer limit, Integer page, String param) {
        Page<TWlbm>pages=new Page<TWlbm>(page,limit);
        Page<TWlbm> tWlbmPage = baseMapper.selectPage(pages, null);
        return ResponseResult.page(0,"success",tWlbmPage.getTotal(),tWlbmPage.getRecords());
    }
}
