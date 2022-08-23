package com.xuanxie.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class RespFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件路径
        String filepath=this.getServletContext().getRealPath("/");
        filepath=filepath+"WEB-INF\\classes\\img\\picture1.jpg";
       // filepath="D:\\javaCode\\maven_test\\model-02-resp\\src\\main\\resources\\img\\picture1.jpg";
        System.out.println("下载文件的路径是:"+filepath);
        //获取文件名
        String filename =filepath.substring(filepath.lastIndexOf('\\')+1);
        //让浏览器知道我们再传输文件和,即让浏览器支持我们需要下载的东西
        //需要设置响应头
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        //获取下载文件的输入流
        FileInputStream in = new FileInputStream(filepath);
        //建立缓冲区
        byte[] buffer=new byte[1024];
        int len=0;
        //获取 输出流
        ServletOutputStream out = resp.getOutputStream();
        //将输入流 经过 缓冲区 输出到输出流中
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        //关闭输入  输出流
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



}
