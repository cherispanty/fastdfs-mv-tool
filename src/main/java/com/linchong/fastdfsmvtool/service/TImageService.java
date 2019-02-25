package com.linchong.fastdfsmvtool.service;

import com.linchong.fastdfsmvtool.entity.TImages;

import java.util.List;
import java.util.Map;

public interface TImageService {
    List<TImages> list(Map<String,Object> map);

    Integer batchUpdate(List<TImages> list);
}
