package Net_chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;

/**
 * 在线聊天室：服务器
 * 目标：使用多线程实现多客户可以多条消息信息
// * 解决问题:其他客户必须等待之前的客户推出，才能继续排队
 目前问题：
 1.代码不好维护
 2.客户端读写没分开：必须先写后读
 解决办法：封装
 */
public class DuoMultiChat02 {
    public static void main(String[] args) throws IOException {
        System.out.println("---serve----");
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了链接");
            new Thread(new Channel(client)).start();
        }
    }
     static class Channel implements Runnable{
            private DataInputStream dis;
            private DataOutputStream dos ;
            private Socket client;
            private boolean isRunning;

            public Channel( Socket client) {
                try {
                    dos = new DataOutputStream(client.getOutputStream());
                    dis = new DataInputStream(client.getInputStream());
                    isRunning = true;
                } catch (IOException e) {
                    release();
                }
                this.client = client;
            }
         //接收消息

            private String receive(){
                String msg = "";
                try {
                    msg = dis.readUTF();
                    dos.writeUTF(msg);
                } catch (IOException e) {
                    release();;
                }
                return msg;
            }
//发送消息
            private void send(String msg){
                try {
                    msg = dis.readUTF();
                    dos.writeUTF(msg);
                } catch (IOException e) {
                    release();;
                }
                //返回消息
                try {
                    dos.flush();
                } catch (IOException e) {
                    release();
                }
}

            //释放资源
            private void release(){
                isRunning = false;
                Utils.close(dis,dos,client);
}

            @Override
            public void run() {
                while (isRunning){
                    String msg = receive();
                    if (!msg.equals((""))){
                        send(msg);
                    }
                }
            }
        }
    }
