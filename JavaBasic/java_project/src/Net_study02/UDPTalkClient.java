package Net_study02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 实现多次：接收端
 *  1.使用DatagramSocket创建接收端
 *  2.准备数据（转成字节数组）
 *  3.封装DatagramSocket包裹（指定地址，ip/端口）
 *  4.发送包裹send(DatagramPacket p)*
 *  5.释放资源
 */
public class UDPTalkClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中....");
        DatagramSocket client = new DatagramSocket(8888);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
            try {
                client.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (data.equals("bye")){
                break;
            }
        }
        client.close();

    }
}
