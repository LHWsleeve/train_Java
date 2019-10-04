package Net_study04;
/**
 * 多个客户端请求
 */

import javax.print.DocFlavor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginMulitServer {
    public static void main(String[] args) throws IOException {
        System.out.println("---serve----");
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning = true;
//                * 1.使用ServerSocket
        while (isRunning) {
            //* 2.阻塞式等待连接accept
            Socket client = server.accept();
            System.out.println("一个客户端建立了链接");
            new Thread(new Chanel(client)).start();
        }
        server.close();
    }
//一个channel代表一个客户端
    static class Chanel implements Runnable{
        private Socket client;
        //输入流
        private DataInputStream dis;
        private  DataOutputStream dos;
        public Chanel(Socket client) {
            this.client = client;
            try {
                //输入流
                dis = new DataInputStream(client.getInputStream());
                //输出流
                dos = new DataOutputStream(client.getOutputStream());

            } catch (IOException e) {
                e.printStackTrace();
                resleas();
            }
        }
        //接收数据
        private String receive(){
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }
        //发送数据
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //释放资源
        private void resleas(){
            try {
                if (null!=dis)
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null!=dos)
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
//  * 3.操作：输入输出流
            String uname = "";
            String upwd = "";

            String[] dataArry = receive().split("&");
            for (String info : dataArry) {
                String[] userinfo = info.split("=");
                if (userinfo[0].equals("uname")) {
                    System.out.println("你的用户名为" + userinfo[1]);
                    uname = userinfo[1];
                } else if (userinfo[0].equals("upwd")) {
                    System.out.println("你的密码为" + userinfo[1]);
                    upwd = userinfo[1];
                }
            }
            if (uname.equals("shsxt") && upwd.equals("laopei")) {//成功
                send("登陆成功，欢迎回来");
            } else {//失败
                send("用户名或密码错误");
            }
            resleas();
        }
    }

}
