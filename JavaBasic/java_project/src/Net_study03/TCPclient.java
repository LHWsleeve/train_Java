package Net_study03;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 熟悉流程：创建客户端
 * 1.使用Socket创建客户端+服务器地址+端口
 * 2.操作：输入输出操作
 * 3.释放资源
 */
public class TCPclient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----client----");
//         * 1.使用Socket创建客户端+服务器地址+端口
        Socket client = new Socket("localhost",8888);
//                * 2.操作：输入输出操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();
//                * 3.释放资源
    }
}
