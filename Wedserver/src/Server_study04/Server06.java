package Server_study04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：加入了Servelt，解耦业务代码

 */
public class Server06 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server06 server = new Server06();
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
    public void  receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立连接....");
            //获取请求协议
            Request request = new Request(client);

            Response response = new Response(client);
            Servlet servlet = null;
            if (request.getUri().equals("login")){
                servlet = new LoginServlet();
            }else if (request.getUri().equals("reg")){
                servlet = new RegisterServlet();
            }else {
                ///
            }
            servlet.service(request,response);
          //关注状态码
            response.push(200);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }
//停止服务
    public void stop(){

    }
}




