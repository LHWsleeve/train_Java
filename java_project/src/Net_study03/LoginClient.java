package Net_study03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 模拟登录：单向
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----client----");
        BufferedReader consloe = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名");
        String uname = consloe.readLine();
        System.out.println("请输入密码");
        String upwd = consloe.readLine();

        //         * 1.使用Socket创建客户端+服务器地址+端口
        Socket client = new Socket("localhost",8888);
//                * 2.操作：输入输出操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
        dos.flush();
//                * 3.释放资源
    }
}
