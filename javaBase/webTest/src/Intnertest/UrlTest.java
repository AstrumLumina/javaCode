package Intnertest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) {
        //url方法
        URL url;
        try {
            //协议 ：// IP地址 : 端口/项目名/参数
            url = new URL("https://www.baidu.com/s?wd=sdhfsjd%27&ie=utf-8&tn=15007414_2_dg");
            System.out.println(url.getProtocol());//协议
            System.out.println(url.getHost());//主机IP
            System.out.println(url.getPath());//文件
            System.out.println(url.getFile());//获取全路径
            System.out.println(url.getQuery());//参数
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //url下载使用*********************************************
        try {
            //此出下载了音乐
            URL url1=new URL("https://dl.stream.qqmusic.qq.com/RS02001U2GJO2hSzQW.mp3?guid=88653584" +
                    "20&vkey=CC035A61812FA40EC438F3EBB2E4D454854826E922ED6770EBFDB05FB2D351B10D96D043A85BD" +
                    "A5CAB4E15FCC62A51DAD78153A7FE29A6CD&uin=3035361676&fromtag=120002");
            //url1=new URL("https://wenku.baidu.com/view/fdc6a3a833687e21ae45a97d.html");
            url1=new URL("https://video.699pic.com/videos/11/96/87/a_D7eZ5FbQqs0n1589119687.mp4");
            HttpURLConnection connection=(HttpURLConnection) url1.openConnection();
            FileOutputStream fout=new FileOutputStream(new File("video.mp4"));
            InputStream urlin =connection.getInputStream();
            byte[] buffer=new byte[1024];
            int len;
            while((len=urlin.read(buffer))!=-1){
                fout.write(buffer,0,len);
            }
            fout.close();
            urlin.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
