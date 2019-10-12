package Net_chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器
 * 目标：实现一个客户可以多条消息信息
 */
public class MultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("---serve----");
        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept();
        System.out.println("一个客户端建立了链接");
        //接收消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        boolean isRunning = true;
        while (isRunning) {
            String msg = dis.readUTF();
            //返回消息
            dos.writeUTF(msg);
            dos.flush();
        }
        //释放资源
        dos.close();
        dis.close();
        client.close();
    }
}