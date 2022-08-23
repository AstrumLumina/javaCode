package Intnertest.NetChat.TcpIp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpService  {
    public static void main(String[] args) {
        ServerSocket sersocket = null;
        Socket socket = null;
        InputStream instream = null;
        ByteArrayOutputStream baos = null;
        try {
            //服务器得有一个地址
            int port = 9999;//设置端口
            sersocket = new ServerSocket(port);
            //2.等待客户端连接
            socket = sersocket.accept();

//            //3.读取客户端的消息
//            instream = socket.getInputStream();
//                /*
//                byte[] buffer=new byte[1024];
//                int len;
//                while((len = instream.read(buffer))!=-1){
//                    String msg=new String(buffer,0,len);
//                    System.out.println(msg);
//                }
//                 */
//            //管道流
//
//            baos = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = instream.read(buffer)) != -1) {
//                baos.write(buffer, 0, len);
//            }
//            System.out.println(baos.toString());

            //接收文件************************************************重新建立连接
            instream= socket.getInputStream();
            FileOutputStream fileout=new FileOutputStream(new File("receive.jpg"));//写出保存到文件
            byte[] buffer=new byte[1024];
            int len1;
            while((len1=instream.read(buffer))!=-1){
                fileout.write(buffer,0,len1);
            }

            //接收完毕，通知客户端
            OutputStream outstream;
            outstream = socket.getOutputStream();
            outstream.write("接收完毕".getBytes());

            //关闭资源
            if(outstream!=null){
                outstream.close();
            }
            fileout.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //先开后关
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (instream != null) {
                try {
                    instream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sersocket != null) {
                try {
                    sersocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Service implements Runnable {
    @Override
    public void run() {
        ServerSocket sersocket = null;
        Socket socket = null;
        InputStream instream = null;
        ByteArrayOutputStream baos = null;
        try {
            //服务器得有一个地址
            int port = 9999;//设置端口
            sersocket = new ServerSocket(port);
            //2.等待客户端连接
            socket = sersocket.accept();
            //3.读取客户端的消息
            instream = socket.getInputStream();
                /*
                byte[] buffer=new byte[1024];
                int len;
                while((len = instream.read(buffer))!=-1){
                    String msg=new String(buffer,0,len);
                    System.out.println("msg");
                }
                 */
            //管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = instream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //先开后关
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (instream != null) {
                try {
                    instream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sersocket != null) {
                try {
                    sersocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
