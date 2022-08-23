package Intnertest.NetChat.TcpIp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {//tcp IP协议 类似于打电话
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outstream = null;
        InputStream instream=null;
        ByteArrayOutputStream inbaos=null;
        try {
            //得到服务器的地址和端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //创建socket（插座）连接
            socket = new Socket(serverIP, port);
            //发送信息
            /*
            outstream = socket.getOutputStream();
            outstream.write("你是谁".getBytes());
            */

            //发送文件**********************************************
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            outstream=socket.getOutputStream();
            FileInputStream filein=new FileInputStream(new File("picture.jpg"));//写入到buffer
            byte[] buffer=new byte[1024];
            int len;
            while((len=filein.read(buffer))!=-1){
                outstream.write(buffer,0,len);
            }
            //通知服务器已经传输完毕
            socket.shutdownOutput();

            //判断是服务器否否接受完毕，若接受完毕则断开连接
            InputStream ins=socket.getInputStream();
            byte[] buffer2=new byte[1024];
            inbaos=new ByteArrayOutputStream();
            while((len=ins.read(buffer2))!=-1){
                inbaos.write(buffer2,0,len);
            }
            if(inbaos.toString().equals("接收完毕")){
                System.out.println(inbaos.toString());
                if(ins!=null){
                    ins.close();
                }
                if(filein!=null){
                    filein.close();
                }
            }

            //聊天
            /*
            String tosay=null;
            Scanner myin=new Scanner(System.in);
            do{
                tosay=myin.nextLine();
                outstream.write(tosay.getBytes());
            }while(!tosay.equals("结束"));
             */

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inbaos!=null){
                try {
                    inbaos.close();
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
            if (outstream != null) {
                try {
                    outstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
class Client implements Runnable {
    @Override
    public void run() {
        Socket socket = null;
        OutputStream outstream = null;
        try {
            //得到服务器的地址和端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //创建socket（插座）连接
            socket = new Socket(serverIP, port);
            //发送信息
            outstream = socket.getOutputStream();
            outstream.write("你是谁".getBytes());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outstream != null) {
                try {
                    outstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
