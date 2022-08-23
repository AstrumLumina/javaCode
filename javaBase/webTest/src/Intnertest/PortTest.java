package Intnertest;

import java.net.InetSocketAddress;

//端口：每个程序有一个端口
//公有端口：0-1023
//程序注册端口：1024-49515
//动态 私有端口 :49152-65535
//cmd命令
//netstat -ano  //查看多有端口
//netstat -ano|findstr "1" //查看定的端口
//tasklist|findstr"1"//查看指定端口对应的的应用
public class PortTest {
    public static void main(String[] args) {
        InetSocketAddress socketaddre=new InetSocketAddress("127.0.0.1",8080);
        System.out.println(socketaddre);
        socketaddre=new InetSocketAddress("localhost",8080);
        System.out.println(socketaddre);
        System.out.println(socketaddre.getAddress());
        System.out.println(socketaddre.getPort());
        System.out.println(socketaddre.getHostName());
        System.out.println(socketaddre.getHostString());

    }
}
