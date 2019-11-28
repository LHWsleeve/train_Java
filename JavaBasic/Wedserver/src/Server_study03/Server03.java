package Server_study03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标：封装响应信息
 * 1.内容可以动态添加
 * 2.关注状态码，拼接好响应的协议信息
 */
public class Server03 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server03 server = new Server03();
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
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024*1024];
            int len = is.read(datas);
            String requestinfo = new String(datas,0,len);
            System.out.println(requestinfo);

            Response response = new Response(client);
            //关注内容
            StringBuilder content = new StringBuilder();
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("server 终于回来了");
            response.print("<body>");
            response.print("</body>");
            response.print ("</html>");
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




