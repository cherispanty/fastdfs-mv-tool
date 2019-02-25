package com.linchong.fastdfsmvtool.service.impl;

import com.linchong.fastdfsmvtool.dao.TImageDao;
import com.linchong.fastdfsmvtool.entity.TImages;
import com.linchong.fastdfsmvtool.service.TImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TImageServiceImpl implements TImageService {
    @Autowired
    private TImageDao tImageDao;

    @Override
    public List<TImages> list(Map<String, Object> map) {
        return tImageDao.list(map);
    }

    @Override
    public Integer batchUpdate(List<TImages> list) {
        Integer rows = tImageDao.batchUpdate(list);
        System.out.println("total update "+rows+" rows");
        return rows;
    }

}
