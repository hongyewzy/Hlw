package com.hlw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hlw.pojo.nydata;
import com.hlw.pojo.supplies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface nyDataMapper extends BaseMapper<nydata> {

    @Select("select * from nydata where id=(select max(id) from nydata);")
    nydata selectNow();
}
