package Intnertest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress address= null;
        try {
            //本机地址 //获取本地IP地址
            address = InetAddress.getByName("127.0.0.1");
            System.out.println(address);

            address = InetAddress.getLocalHost();
            System.out.println(address);

            address=InetAddress.getLoopbackAddress();
            System.out.println(address);
            //获取其他地址其他
            address=InetAddress.getByName("www.baidu.com");
            System.out.println(address);

            //其他方法
            address=InetAddress.getByName("107.148.151.751");
            System.out.println(address);
            System.out.println("************************");
            System.out.println(address.getAddress());
            System.out.println(address.getHostAddress());//获得本机规范的名字
            System.out.println(address.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch( Exception e){
            e.printStackTrace();
        }

    }

}
