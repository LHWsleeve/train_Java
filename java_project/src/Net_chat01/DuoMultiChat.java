package Net_chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器
 * 目标：使用多线程实现多客户可以多条消息信息
// * 解决问题:其他客户必须等待之前的客户推出，才能继续排队
 目前问题：
 1.代码不好维护
 2.客户端读写没分开：必须先写后读
 */
public class DuoMultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("---serve----");
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了链接");
            new Thread(()->{
                //接收消息
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(client.getOutputStream());
                    dis = new DataInputStream(client.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {
                    //接收消息
                    String msg = null;
                    try {
                        msg = dis.readUTF();
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //返回消息
                    try {
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //释放资源
                try {
                    dos.close();
                    dis.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
