package Intnertest.NetChat.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServe {
    public static void main(String[] args) {
        try {
            //开放端口
            int port=9999;
            DatagramSocket socket=new DatagramSocket(port);
            //接收数据包
            byte[] buffer=new byte[1024];
            DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);
            socket.receive(packet);
            //查看接收
            System.out.println(packet.getAddress().getHostAddress());
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
            //关闭连接
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
