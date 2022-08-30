package com.hlw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hlw.pojo.nydata;
import com.hlw.pojo.supplies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface suppliesMapper extends BaseMapper<supplies> {

    @Select("select * from supplies where id=(select max(id) from supplies);")
    supplies selectNow();

}
