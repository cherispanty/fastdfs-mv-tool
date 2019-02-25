package com.linchong.fastdfsmvtool.controller;

import com.linchong.fastdfsmvtool.entity.TMsg;
import com.linchong.fastdfsmvtool.service.TMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TMsgController {

    @Autowired
    private TMsgService tMsgService;

    @RequestMapping("/getMsgById")
    @ResponseBody
    public TMsg getMsgById(Integer id) {
        return tMsgService.getMsgById(id);
    }
}
