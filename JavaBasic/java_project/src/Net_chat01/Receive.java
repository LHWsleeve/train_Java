package Net_chat01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 多线程封装接收端
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    Socket client;
    private boolean isRunning = true;
public Receive(Socket client) {
 this.client = client;
    try {
        dis = new DataInputStream(client.getInputStream());
    } catch (IOException e) {
        release();
    }
}

    private String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            release();;
        }
        return msg;
    }

    @Override
    public void run() {
    while (isRunning){
        String  msg = receive();
        if (!msg.equals("")){
            System.out.println(msg);
        }
    }
    }



    private void release() {
        isRunning = false;
        Utils.close(dis, client);
    }
}
