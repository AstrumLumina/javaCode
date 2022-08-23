package Intnertest.NetChat.WeChat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive implements Runnable{
    private int myport=0;
    private DatagramSocket socket=null;
    private DatagramPacket packet=null;
    private String fromname=null;
    public Receive(int myport,String fromname){
        this.myport=myport;
        this.fromname=fromname;
        try {
            socket=new DatagramSocket(myport);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){
            try {
                byte[] container=new byte[1024];
                packet=new DatagramPacket(container,0,container.length);
                socket.receive(packet);
                byte[] dates= packet.getData();
                String received=new String(dates,0,packet.getLength());
                System.out.println(fromname+" : "+received);
                if(received.equals("goodby!")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(socket!=null)
            socket.close();
    }
}
