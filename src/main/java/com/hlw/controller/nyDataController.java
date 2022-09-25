package com.hlw.controller;

import com.hlw.pojo.nydata;
import com.hlw.pojo.supplies;
import com.hlw.service.nyDataService;
import com.hlw.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/ny"})
public class nyDataController {
    @Autowired

    private nyDataService service;

    @GetMapping
    public R getAll() {
        List<nydata> list = new ArrayList<>();
        log.info("这里是nyDataController");
        nydata now = service.selectNow();
        list.add(now);
        log.info("数据为为:{}", now);
        return R.success(list);
    }

    @PostMapping
    public R save(@RequestBody nydata nydata) {
        Boolean flag = service.save(nydata);
        if (flag)
            return R.success("成功");
        else
            return R.error("添加失败，请找出问题");
    }

    @GetMapping("/basexx")
    public R<supplies> basexx(String feng1, String feng2, String deng1,String deng2) {
        supplies tqj = new supplies(feng1, feng2, deng1,deng2);
        return R.success(tqj);
    }

    @GetMapping("/feng1")
    public R<String> changefeng1(String feng1) {
        /**
         * 这里需要传送数据给服务器，让硬件改变feng1的状态
         */

        return R.success("成功");
    }

    @GetMapping("/feng2")
    public R<String> changefeng2(String feng2) {

        return R.success("成功");
    }

    @GetMapping("/deng1")
    public R<String> changedeng1(String deng1) {

        return R.success("成功");
    }

    @GetMapping("/deng2")
    public R<String> changedeng2(String deng2) {

        return R.success("成功");
    }

    @GetMapping("/All")
    public R<List<String>> getAllbase(){
        List<String> list=service.selectAll();
        return R.success(list);
    }

    @GetMapping("/getAll")
    public R<List<nydata>> getAllnydata(){
        List<nydata> list=service.GetAll();
        return R.success(list);
    }




}
