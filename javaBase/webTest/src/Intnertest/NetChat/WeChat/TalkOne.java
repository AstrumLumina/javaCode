package Intnertest.NetChat.WeChat;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TalkOne {
    public static void main(String[] args) {
        new Thread(new Receive(666,"老师")).start();//自己的端口和另一方的名字
        try {
            new Thread(new Talk(InetAddress.getByName("localhost"),888)).start();//另一方的地址
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
