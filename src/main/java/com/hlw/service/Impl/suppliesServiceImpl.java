package com.hlw.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlw.dao.nyDataMapper;
import com.hlw.dao.suppliesMapper;
import com.hlw.pojo.nydata;
import com.hlw.pojo.supplies;
import com.hlw.service.nyDataService;
import com.hlw.service.suppliesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
@Slf4j
public class suppliesServiceImpl extends ServiceImpl<suppliesMapper, supplies> implements suppliesService {
    @Autowired
    private suppliesMapper suppliesDao;

    @Override
    public void savesup(supplies supplies) {
        SimpleDateFormat time = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        supplies.setDate(String.valueOf(time));
        suppliesDao.insert(supplies);
    }

    @Override
    public supplies selectNow() {
        log.info("这里是suppliesServiceImpl");
        supplies now = suppliesDao.selectNow();
        return now;
    }
}
