package com.linchong.fastdfsmvtool.service.impl;

import com.linchong.fastdfsmvtool.dao.TMsgDao;
import com.linchong.fastdfsmvtool.entity.TMsg;
import com.linchong.fastdfsmvtool.service.TMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TMsgServiceImpl implements TMsgService {
    @Autowired
    private TMsgDao tMsgDao;

    @Override
    public TMsg getMsgById(Integer id) {
        return tMsgDao.getMsgById(id);
    }
}
