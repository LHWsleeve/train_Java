package Net_chat01;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----client----");
        Socket client = new Socket("localhost",8888);
        //发消息
        BufferedReader consloe = new BufferedReader(new InputStreamReader(System.in));
        String msg = consloe.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
        //获取消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        msg = dis.readUTF();
        System.out.println(msg);

        dos.close();
        dis.close();
        client.close();
    }
}
