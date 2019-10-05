package Net_Chat04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在线聊天室：服务器
 * 目标：实现私聊
 */
public class Chat {
    //使用并发环境下用copyxxxx操作容器保证并发安全
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("---serve----");
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了链接");
            Channel c = new Channel(client);
            all.add(c);
            new Thread(c).start();
        }
    }
     static class Channel implements Runnable{
        private String name;
        private DataInputStream dis;
        private DataOutputStream dos ;
        private Socket client;
        private boolean isRunning;

        public Channel(Socket client) {
            try {
                dos = new DataOutputStream(client.getOutputStream());
                dis = new DataInputStream(client.getInputStream());
                isRunning = true;
                //获取名称
                this.name = receive();
                this.send("欢迎您");
                sendOthers(this.name+"来到了聊天室",true);
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
                release();
            }
            return msg;
        }
//发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
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

         /**
          * 私聊约定数据格式：@xxx：msg
          * @param msg
          * @param isSys
          */
//获取消息发给其他人
        private void sendOthers(String msg,boolean isSys) {
            boolean isPrivate = msg.startsWith("@");
            if (isPrivate) {
                int idx = msg.indexOf(":");
                //获取目标和数据
                String targetName = msg.substring(1, idx);
                msg = msg.substring(idx + 1);
                for (Channel other : all) {
                    if (other.name.equals(targetName)) {
                        other.send(this.name + "悄悄的对你说" + msg);
                    }
                }
            } else {
                for (Channel others : all) {
                    if (others == this) {
                        continue;
                    }
                    if (!isSys) {
                        others.send(this.name + "对所有人说" + msg);
                    } else {
                        others.send(msg);//系统消息
                    }
                }
            }
        }

        //释放资源
        private void release(){
            isRunning = false;
            Utils.close(dis,dos,client);
            //退出
            all.remove(this);
            sendOthers(this.name+"离开",true);
}

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if (!msg.equals((""))){
//                        send(msg);
                sendOthers(msg,false);
                }
            }
        }
    }
}
