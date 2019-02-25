package com.linchong.fastdfsmvtool.dao;

import com.linchong.fastdfsmvtool.entity.TImages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TImageDao {
    List<TImages> list(Map<String,Object> map);

    Integer batchUpdate(@Param(value = "list")List<TImages> list);
}
