package com.hlw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hlw.pojo.nydata;
import com.hlw.pojo.supplies;

import java.util.List;

public interface suppliesService extends IService<supplies> {

    public void savesup(supplies supplies);

    public supplies selectNow();

}
