package Net_study03;

import java.awt.desktop.SystemSleepEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        System.out.println("---serve----");
        ServerSocket server = new ServerSocket(8888);
//                * 1.使用ServerSocket
        Socket client = server.accept();
//                * 2.阻塞式等待连接accept
        System.out.println("一个客户端建立了链接");
//                * 3.操作：输入输出流
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        String[] dataArry = data.split("&");
        for (String info : dataArry) {
            String[] userinfo = info.split("=");
            if (userinfo[0].equals("uname")) {
                System.out.println("你的用户名为" + userinfo[1]);
            } else if (userinfo[0].equals("upwd")) {
                    System.out.println("你的密码为" + userinfo[1]);
                }
            //                * 4.释放资源
            dis.close();
            client.close();
        }
    }
}
