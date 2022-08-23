package Intnertest.NetChat.WeChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Talk implements Runnable{
    private int toport=0;
    private InetAddress toip=null;
    private DatagramPacket packet=null;
    private DatagramSocket socket=null;
   // private byte[] data=new byte[1024];
    private BufferedReader reader=null;
    public Talk(InetAddress toip,int toport){
        this.toip=toip;
        this.toport=toport;
        reader=new BufferedReader(new InputStreamReader(System.in));
       // packet=new DatagramPacket(data,0,data.length,toip,toport);
        try {
            socket=new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            while(true){
                System.out.print("我 : ");
                String totalk = reader.readLine();
                packet=new DatagramPacket(totalk.getBytes(),0,totalk.getBytes().length,toip,toport);
                socket.send(packet);
                if(totalk.equals("goodbye")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
