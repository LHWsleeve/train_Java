package Server_study05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：整合配置文件

 */
public class Server07 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server07 server = new Server07();
        server.start();
        server.receive();
    }

    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }
//接受连接，处理
    public void  receive()   {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立连接....");
            //获取请求协议
            Request request = new Request(client);

            Response response = new Response(client);
            Servlet servlet = null;
            try {
                servlet = WebApp.gtServletFromURL(request.getUri());
                servlet.service(request,response);
                //关注状态码
                response.push(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }
//停止服务
    public void stop(){

    }
}




