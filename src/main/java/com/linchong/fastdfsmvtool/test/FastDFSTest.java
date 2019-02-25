package com.linchong.fastdfsmvtool.test;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FastDFSTest {

	public static void main(String[] args) throws IOException, MyException {
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
        String[] upload_file = storageClient.upload_file("E:/test.png", "png", null);

        //upload_file 存储着访问路径
        for(String s : upload_file){
            System.out.println(s);
        }
	}

}
