package com.hlw.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlw.dao.nyDataMapper;
import com.hlw.pojo.nydata;
import com.hlw.service.nyDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class nyDataServiceImpl extends ServiceImpl<nyDataMapper, nydata> implements nyDataService {

    @Autowired
    private nyDataMapper nydataDao;

    @Override
    public nydata selectNow() {
        log.info("这里是nydataServiceImpl");
        nydata now = nydataDao.selectNow();
        return now;
    }


    @Override
    public List<String> selectAll() {
        List<String> list = nydataDao.slecctAll();
        return list;
    }

    @Override
    public List<nydata> GetAll() {
        List<nydata> list=nydataDao.GetAll();
        return list;
    }



}
