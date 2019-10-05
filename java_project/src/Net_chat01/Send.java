package Net_chat01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送端
 */
public class Send implements Runnable {
    private BufferedReader consloe;
    DataOutputStream dos;
    Socket client;
    private boolean isRunning = true;

    public Send(Socket client) {
        this.client = client;
        consloe = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            release();
        }
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = getStrFromCpnsloe();
            if (!msg.equals("")){
                send(msg);
            }
        }

    }

    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            release();;
        }
    }

    //从控制台获取消息
    private String getStrFromCpnsloe(){
        try {
            return consloe.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //释放资源
    private void release() {
        isRunning = false;
        Utils.close(dos, client);
    }
}
