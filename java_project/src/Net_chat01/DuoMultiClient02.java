package Net_chat01;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：显示多客户正常发多条消息
 * 问题:其他客户必须等待之前的客户推出，才能继续排队
 */
public class DuoMultiClient02 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----client----");
        Socket client = new Socket("localhost", 8888);
        //发消息
        new Thread(new Send(client)).start();
        //获取消息
        new Thread(new Receive(client)).start();
    }
}
