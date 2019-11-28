package Server_study05;

public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        StringBuilder content = new StringBuilder();
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("第一个Servlet");
        response.print("</title>");
        response.print("</head>");
        response.print("欢迎回来"+request.getparameterValues("uname"));
        response.print("<body>");
        response.print("</body>");
        response.print ("</html>");

    }
}
