package com.xuanxie.servlet;

import sun.awt.image.BufferedImageDevice;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class IdentifyPicture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器每隔几秒刷新一次
        resp.setHeader("refresh","1");//4秒刷新一次

        //在内存中创建一个图片对象
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graph=(Graphics2D) image.getGraphics();//可以想象为拿到一支画笔
        //设置图片
        //设置背景
        graph.setColor(Color.white);//设置画笔的颜色
        graph.fillRect(0,0,80,20);
        //设置图片中的数字
        graph.setColor(Color.black);
        graph.setFont(new Font(null,Font.BOLD,20));
        graph.drawString(makeNum(),0,20);
        //告诉浏览器用图片的格式打开此次响应
        resp.setContentType("image/jpg");
        //网站存在缓存,要设置不让他缓存  一下几种方式都可以
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cach");
        resp.setHeader("pragma","no-cach");

        //把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
    //生成随机数的函数
    private String makeNum(){
        Random random=new Random();
        int len=6;
        StringBuffer idenfitycode=new StringBuffer();
        for(int i=0;i<len;++i){
            int num=random.nextInt(9);
            idenfitycode.append(num+"0");
        }
       return idenfitycode.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
