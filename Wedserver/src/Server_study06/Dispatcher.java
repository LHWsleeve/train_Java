package Server_study06;
/**
 * 分发器
 */

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable {
    private Socket client;
    private Request request;
    private Response response;
    public Dispatcher(Socket client) {//封装请求和响应
        this.client = client;
        try {
            request = new Request(client);
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }

    @Override
    public void run() {
        Servlet servlet = null;
        try {
            servlet = WebApp.gtServletFromURL(request.getUri());
            servlet.service(request,response);
            //关注状态码
            response.push(200);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.push(500);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        release();
    }

    private void release(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

