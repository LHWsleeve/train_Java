package Server_study06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：多线程处理，计入分发器

 */
public class Server08 {
    private ServerSocket serverSocket;
    private  boolean isRunning;
    public static void main(String[] args) {
        Server08 server = new Server08();
        server.start();
        server.receive();
    }

    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
            stop();

        }
    }
//接受连接，处理
    public void  receive()   {
        while (isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立连接....");
                //多线程
                new Thread(new Dispatcher(client)).start();
                //获取请求协议
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端错误");
            }
        }
    }
//停止服务
    public void stop(){
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




