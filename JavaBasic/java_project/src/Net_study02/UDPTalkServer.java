package Net_study02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * 1.使用DatagramSocket创建接收端
 * 2.准备容器 封装DatagramSocket包裹
 * 3.阻塞式接受包裹receive
 * 4.分析数据
 * byte[] getData()
 *        getLenth()
 *5.释放资源
 */
public class UDPTalkServer {
    public static void main(String[] args) throws SocketException {
        System.out.println("接收端启动总....");
        //创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        while (true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            try {
                server.receive(packet);
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String data = new String(datas,0,len);
                System.out.println(data);
                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
