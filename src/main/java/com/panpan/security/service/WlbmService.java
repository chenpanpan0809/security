package com.panpan.security.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.panpan.security.common.ResponseResult;
import com.panpan.security.entity.TWlbm;

public interface WlbmService extends IService<TWlbm> {

    ResponseResult getPage(Integer limit, Integer page, String param);

}
