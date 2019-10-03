package Net_study02;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 基本类型：接收端
 * 1.使用DatagramSocket创建接收端
 * 2.准备容器 封装DatagramSocket包裹
 * 3.阻塞式接受包裹receive
 * 4.分析数据 将字节数组还原为对应类型
 * byte[] getData()
 *        getLenth()
 *5.释放资源
 */
public class UDPTypeServer {
    public static void main(String[] args) throws SocketException {
        System.out.println("接收端启动总....");
        //创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        byte[]container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        try {
            server.receive(packet);
            byte[]datas = packet.getData();
            int len = packet.getLength();
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
            String msg = dis.readUTF();
            boolean flag = dis.readBoolean();
            char ch = dis.readChar();
            System.out.println(msg+"----"+flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
