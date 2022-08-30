package com.hlw.controller;

import com.hlw.pojo.supplies;
import com.hlw.service.suppliesService;
import com.hlw.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/supplies"})
public class suppliesController {

    @Autowired
    private suppliesService service;

    @GetMapping
    private R<supplies> getAll(){
        log.info("这里是suppliesController");
        supplies now=service.selectNow();
        log.info("数据为为:{}",now);
        return R.success(now);
    }


}
