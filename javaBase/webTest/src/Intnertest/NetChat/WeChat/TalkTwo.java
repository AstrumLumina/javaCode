package Intnertest.NetChat.WeChat;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TalkTwo {
    public static void main(String[] args) {
        Thread receive= null;//另一方的地址
        try {
            receive = new Thread(new Talk(InetAddress.getByName("localhost"),666));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Thread talk= new Thread(new Receive(888,"学神"));//自己的端口和另一方的名字
        talk.start();
        receive.start();
    }
}
