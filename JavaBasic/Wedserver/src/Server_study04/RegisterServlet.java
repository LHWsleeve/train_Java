package Server_study04;

import Server_study04.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request,Response response) {
        response.print("注册成功");
    }
}
