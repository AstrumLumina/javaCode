import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class UDPSearcher {
    public static void main(String[] args) throws Exception {
        System.out.println("UDPSearcher Started.");
        //作为搜索方,让系统自动分配端口
        DatagramSocket ds = new DatagramSocket();

        //构建发送数据
        String requestData = "HelloWord!";
        byte[] requestDataBytes = requestData.getBytes();
        DatagramPacket requestPacket = new DatagramPacket(requestDataBytes, requestDataBytes.length);

        requestPacket.setAddress(InetAddress.getByName("10.128.15.149"));
        requestPacket.setPort(20000);

        ds.send(requestPacket);

        final byte[] buf = new byte[512];
        DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

        ds.receive(receivePack);

        String ip = receivePack.getAddress().getHostAddress();
        int port = receivePack.getPort();
        int dataLen = receivePack.getLength();
        String data = new String(receivePack.getData(), 0, dataLen);
        System.out.println("UDPSearcher receive from ip: " + ip + "\tport: " + port + "\tdata: " + data);

        System.out.println("UDPSearcher Finished!");
        ds.close();
    }
}
