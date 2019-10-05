package Net_Chat02;

import Net_Chat02.Receive;
import Net_Chat02.Send;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：加入容器实现群聊
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----client----");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名");
        String name = br.readLine();

        Socket client = new Socket("localhost", 8888);
        //发消息
        new Thread(new Send(client,name)).start();
        //获取消息
        new Thread(new Receive(client)).start();
    }
}
