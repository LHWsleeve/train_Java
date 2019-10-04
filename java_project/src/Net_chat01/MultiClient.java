package Net_chat01;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：显示一个客户正常发多条消息
 */
public class MultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----client----");
        Socket client = new Socket("localhost",8888);
        //发消息
        BufferedReader consloe = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        //获取消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRunning = true;
        while (isRunning) {
            String msg = consloe.readLine();
            dos.writeUTF(msg);
            dos.flush();
            msg = dis.readUTF();
            System.out.println(msg);
        }
        dos.close();
        dis.close();
        client.close();
    }
}
