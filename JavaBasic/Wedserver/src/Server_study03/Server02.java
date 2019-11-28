package Server_study03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标：返回响应协议
 */
public class Server02 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server02 server = new Server02();
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
            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("</head>");
            content.append("server 终于回来了");
            content.append("<body>");
            content.append("</body>");
            content.append("</html>");
            int size = content.toString().getBytes().length;//必须获取字节长度
            StringBuilder reposeInfo = new StringBuilder();
            String blank = "";
            String CRLF ="\r\n";
            //返回
            //1， 响应行:HTTP/1.1 00 OK
            reposeInfo.append("HTTP/1.1").append(blank);
            reposeInfo.append(200).append(blank);
            reposeInfo.append("OK").append(CRLF);
            //2. 响应头：xxxxxxxxxxxx一堆
            reposeInfo.append("Date:").append(new Date()).append(CRLF);
            reposeInfo.append("Server:").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
            reposeInfo.append("Content-typr:text/html").append(CRLF);
            reposeInfo.append("Content-length:").append(size).append(CRLF);
            reposeInfo.append(CRLF);
            //3.正文（2，3之间有一个空行）
            reposeInfo.append(content.toString());

            //写出到客户端
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(reposeInfo.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }
//停止服务
    public void stop(){

    }
}




