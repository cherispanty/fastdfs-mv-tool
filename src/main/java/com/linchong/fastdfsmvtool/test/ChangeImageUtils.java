package com.linchong.fastdfsmvtool.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.IOException;

public class ChangeImageUtils {
    private static OkHttpClient client = new OkHttpClient();

    public static byte[] run(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        byte[] bytes = null;
        try {
            response = client.newCall(request).execute();
            bytes = response.body().bytes();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return bytes;
    }


    public static String[]  uploadImage(String path) throws Exception {
        if(path == null || "".equals(path)) {
            return null;
        }

        //1 获取图片流
        byte[] response = run(path);
        String file_ext_name =  path.substring(path.lastIndexOf(".")+1);

        //2 上传至新的服务器

        // TODO Auto-generated method stub
        // 向项目中添加jar包
        // 创建一个配置文件配置tracker服务器地址
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

        //利用storageclient对象上传图片

        String[] upload_file = storageClient.upload_file(response,file_ext_name,null);

        //upload_file 存储着访问路径
        for(String s : upload_file){
            System.out.println(s);
        }
        return upload_file;
    }


//    public static void main(String[] args) {
//        File file = new File("HelloWorld.png");
//        String fileName = file.getName();
//        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//        System.out.println(suffix);
//    }
}
