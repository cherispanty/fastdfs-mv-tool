package com.linchong.fastdfsmvtool.controller;

import com.linchong.fastdfsmvtool.entity.TImages;
import com.linchong.fastdfsmvtool.entity.TMsg;
import com.linchong.fastdfsmvtool.service.TImageService;
import com.linchong.fastdfsmvtool.service.TMsgService;
import com.linchong.fastdfsmvtool.test.ChangeImageUtils;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TImageController {

    @Autowired
    private TImageService tImageService;

    @RequestMapping("/list")
    @ResponseBody
    public Integer list() {
        List<TImages> list = tImageService.list(new HashMap<>());

        try {
            //加载配置文件
            ClientGlobal.init("fdfs.conf");

            //创建一个tracker客户端对象
            TrackerClient trackerClient = new TrackerClient();

            //使用trackerclient连接trackersever对象
            TrackerServer trackerServer = trackerClient.getConnection();

            //创建一个straged server对象
            StorageServer storageServer = null;

            //创建一个storage client 对象
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            for (TImages t:
                 list) {
                System.out.println(t.getImageId()+"   "+t.getImageUrl()+"   "+t.getThumbnailUrl());

                    String path = t.getImageUrl();
                    String file_ext_name = null;
                    byte[] response = ChangeImageUtils.run(path);
                    int flag = 0;
                    if(response == null) {
                        System.out.println(path+"  request data fail!");
                        flag = -1;
                    }
                    if(flag == 0) {
                        file_ext_name =  path.substring(path.lastIndexOf(".")+1);
                        String[] strings = storageClient.upload_file(response,file_ext_name,null);
                        String newImageUrl = "https://qlw.soholy.cn/pic/" + strings[0] + "/"+strings[1];
                        t.setImageUrl(newImageUrl);
                        System.out.println("new pic url:"+newImageUrl);
                    }


                    path = t.getThumbnailUrl();
                    response = ChangeImageUtils.run(path);
                    if(response == null) {
                        System.out.println(path+"  request data fail!");
                        continue;
                    }
                    file_ext_name =  path.substring(path.lastIndexOf(".")+1);
                    String[] thums = storageClient.upload_file(response,file_ext_name,null);
                    String newThumbnailUrl = "https://qlw.soholy.cn/pic/" + thums[0] + "/"+thums[1];
                    t.setThumbnailUrl(newThumbnailUrl);
                    System.out.println("new pic url:"+newThumbnailUrl);
                }
            //更新数据的url
            tImageService.batchUpdate(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.size();
    }

//    @ResponseBody
//    @RequestMapping("/batchUpdate")
//    public Integer batchUpdate() {
//        List<TImages> list = new ArrayList<>();
//        TImages tImages = new TImages();
//        tImages.setImageId(201L);
//        tImages.setImageUrl("https://mytest1");
//        tImages.setThumbnailUrl("https://mytest1");
//
//        TImages tImages2 = new TImages();
//        tImages2.setImageId(202L);
//        tImages2.setImageUrl("https://mytest2");
//        tImages2.setThumbnailUrl("https://mytest2");
//        list.add(tImages);
//        list.add(tImages2);
//
//        return tImageService.batchUpdate(list);
//    }
}
