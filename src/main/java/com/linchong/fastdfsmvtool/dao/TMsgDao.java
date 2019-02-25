package com.linchong.fastdfsmvtool.dao;

import com.linchong.fastdfsmvtool.entity.TMsg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMsgDao {
    TMsg getMsgById(Integer id);
}
