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
    public R<supplies> basexx(String feng1, String feng2, String deng) {
        supplies tqj = new supplies(feng1, feng2, deng);
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

    @GetMapping("/deng")
    public R<String> changedeng(String deng) {

        return R.success("成功");
    }

}
