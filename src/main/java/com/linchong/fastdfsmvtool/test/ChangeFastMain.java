package com.linchong.fastdfsmvtool.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChangeFastMain {
	private static OkHttpClient client = new OkHttpClient();

	public static byte[] run(String url) throws IOException {
	  Request request = new Request.Builder()
	      .url(url)
	      .build();

	  Response response = client.newCall(request).execute();
	  return response.body().bytes();
	}
	
	public static void main(String[] args) throws Exception {
//		ChangeFastMain example = new ChangeFastMain();
////		byte[] response = example.run("https://nm.soholy.cn/pic/group1/M00/00/17/rBLbnVvzweWALIyHAAA3T1ncyZA199.jpg");
////	    saveFile("test.jpg",response);
//		while(true) {
//			example.run("http://localhost:8001/dept/get/1");
//		}
//		for(int i= 0 ;i < 10;i++) {
//			MyThread t = new MyThread();
//			t.start();
//		}
        ChangeFastMain example = new ChangeFastMain();
        byte[] response = example.run("https://qlw.soholy.cn/pic/group1/M00/00/09/rBJwu1wPYVSAMfHMAABA4et-kIg225.png");
	    saveFile("test.png",response);
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
