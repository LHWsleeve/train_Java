package Server_study06;
/**
 * 分发器：加入状态内容处理，404 505，首页
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Dispatcher02 implements Runnable {
    private Socket client;
    private Request request;
    private Response response;
    public Dispatcher02(Socket client) {//封装请求和响应
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
        if (null==request.getUri()||request.getUri().equals("")){
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
            try {
                response.print(new String(is.readAllBytes()));
                response.push(200);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        try {
            servlet = WebApp.gtServletFromURL(request.getUri());
            servlet.service(request,response);
            //关注状态码
            response.push(200);
        } catch (Exception e) {
            e.printStackTrace();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
            try {
                response.print(new String(is.readAllBytes()));
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                response.push(404);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                response.print("服务器正在维护");
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

