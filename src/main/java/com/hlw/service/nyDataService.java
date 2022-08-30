package com.hlw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hlw.pojo.nydata;

public interface nyDataService extends IService<nydata> {

    public nydata selectNow();
}
