package Net_study02;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 基本类型接收端
 *  1.使用DatagramSocket创建接收端
 *  2.将基本类型（转成字节数组）
 *  3.封装DatagramSocket包裹（指定地址，ip/端口）
 *  4.发送包裹send(DatagramPacket p)*
 *  5.释放资源
 */
public class UDPTypeClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中....");
        DatagramSocket client = new DatagramSocket(8888);
        //准备数据转成字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("码农");
        dos.write(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
        try {
            client.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.close();

    }
}
