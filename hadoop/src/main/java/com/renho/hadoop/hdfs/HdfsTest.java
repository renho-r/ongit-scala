package com.renho.hadoop.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;

/**
 * Created by renho on 2016/1/6.
 */
public class HdfsTest {
    public static void main(String[] args) {
        try {
            args = new String[]{"d://sparkData/hdfs", "/renho/out/URLCat.java"};

            Configuration conf = new Configuration();
            FileSystem hdfs = FileSystem.get(conf); //获得HDFS文件系统的对象
            FileSystem local = FileSystem.getLocal(conf);//获得本地文件系统的对象
            Path inputDir = new Path(args[0]);//设定输入目录
            Path hdfsFile = new Path(args[1]);//设定输出目录
            FileStatus[] inputFiles = local.listStatus(inputDir);//FileStatus的listStatus()方法获得一个目录中的文件列表
            FSDataOutputStream out = hdfs.create(hdfsFile);//生成HDFS输出流
            for (int i = 0; i < inputFiles.length; i++) {
                System.out.println(inputFiles[i].getPath().getName());
                FSDataInputStream in = local.open(inputFiles[i].getPath());//打开本地输入流
                byte[] buffer = new byte[256];
                int bytesRead = 0;
                while ((bytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, bytesRead);//通过一个循环来写入
                }
                in.close();
            }
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
