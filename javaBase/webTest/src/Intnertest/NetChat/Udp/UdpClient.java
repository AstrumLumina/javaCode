package Intnertest.NetChat.Udp;

import java.io.IOException;
import java.net.*;

public class UdpClient {//udp协议类似于发短信
    public static void main(String[] args) {
        //1.建立一个Socket类
        DatagramSocket socket= null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        //2.建立包
        String msg="你好，服务器";
        InetAddress localhost= null;
        try {
            localhost = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        int port=9999;//服务器端口号
        //发送数据的信息 发什么（数组的位置），发给谁
        DatagramPacket packet=new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);
        //发送
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关闭socket
        socket.close();
    }
}

