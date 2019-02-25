package com.linchong.fastdfsmvtool.test;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FastDFSTest {

	public static void main(String[] args) throws IOException, MyException {
		// TODO Auto-generated method stub
		// ����Ŀ�����jar��
        // ����һ�������ļ�����tracker��������ַ
        //���������ļ�
        ClientGlobal.init("fdfs.conf"); 

        //����һ��tracker�ͻ��˶���
        TrackerClient trackerClient = new TrackerClient(); 

        //ʹ��trackerclient����trackersever����
        TrackerServer trackerServer = trackerClient.getConnection(); 

        //����һ��straged server���� 
        StorageServer storageServer = null; 

        //����һ��storage client ����
        StorageClient storageClient = new StorageClient(trackerServer, storageServer); 

        //����storageclient�����ϴ�ͼƬ
        //����һΪ�ļ����ڵ�·������Ҫ�����ģ�
        //������Ϊ�ļ�����չ��
        //������Ϊ�ļ���չ��Ϣ 
        String[] upload_file = storageClient.upload_file("E:/test.png", "png", null);

        //upload_file �洢�ŷ���·��
        for(String s : upload_file){
            System.out.println(s);
        }
	}

}
