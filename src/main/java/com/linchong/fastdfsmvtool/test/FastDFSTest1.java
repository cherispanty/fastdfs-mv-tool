package com.linchong.fastdfsmvtool.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FastDFSTest1 {
    private static OkHttpClient client = new OkHttpClient();

    public static byte[] run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().bytes();
    }

    public static void main(String[] args) throws Exception {
        ChangeFastMain example = new ChangeFastMain();
        byte[] response = example.run("https://qlw.soholy.cn/pic/group1/M00/00/00/rBJwu1vP6BmAVXMwAAAHBMtwhyQ188.jpg");
//        saveFile("test2.png",response);

        //上传至新的服务器
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
        //参数一为文件所在的路径（不要有中文）
        //参数二为文件的拓展名
        //参数三为文件扩展信息
        String[] upload_file = storageClient.upload_file(response,"jpg",null);

        //upload_file 存储着访问路径
        for(String s : upload_file){
            System.out.println(s);
        }


    }


    /**
     * 将字节流转换成文件
     * @param filename
     * @param data
     * @throws Exception
     */
    public static void saveFile(String filename,byte [] data)throws Exception{
        if(data != null){
            String filepath ="E:\\" + filename;
            File file  = new File(filepath);
            if(file.exists()){
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data,0,data.length);
            fos.flush();
            fos.close();
        }
    }
}
