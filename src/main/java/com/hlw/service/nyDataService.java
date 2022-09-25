package com.hlw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hlw.pojo.nydata;

import java.util.List;

public interface nyDataService extends IService<nydata> {

    public nydata selectNow();

    public List<String> selectAll();

    public List<nydata> GetAll();

}
