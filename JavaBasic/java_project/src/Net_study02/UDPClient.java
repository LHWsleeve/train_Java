package Net_study02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 接收端
 *  1.使用DatagramSocket创建接收端
 *  2.准备数据（转成字节数组）
 *  3.封装DatagramSocket包裹（指定地址，ip/端口）
 *  4.发送包裹send(DatagramPacket p)*
 *  5.释放资源
 */
public class UDPClient {
    public static void main(String[] args) throws SocketException {
        System.out.println("发送方启动中....");
        DatagramSocket client = new DatagramSocket(8888);
        String data = "上海尚学堂";
        byte[] datas = data.getBytes();
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
        try {
            client.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.close();

    }
}
