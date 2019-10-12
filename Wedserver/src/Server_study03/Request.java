package Server_study03;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 封装请求协议
 * 目标：获取method uri以及请求参数
 */
public class Request {
    private final String CRLF ="\r\n";
    //协议信息
    private String requsetinfo;
    //请求方式
    private String method;
    //请求uri
    private String uri;
    //请求参数
    private String queryStr;

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }


    public Request(InputStream is) {
        byte[] datas = new byte[1024 * 1024];
        int len;
        try {
            len = is.read(datas);
            System.out.println(datas);
            this.requsetinfo = new String(datas, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestinfo();
    }

    public void parseRequestinfo() {
        System.out.println("____分解————————");
        System.out.println("---1.获取请求方式：开头到第一个/----");
        this.method = this.requsetinfo.substring(0, this.requsetinfo.indexOf("/")).toLowerCase();
        this.method = method.trim();
        System.out.println("2.获取请求的url：第一个/到HTTP/--");
        //可能存在参数。若又？则有参数，？前面为url
        //①获取/的位置
        int startIdx = this.requsetinfo.indexOf("/") + 1;
        //②获取HTTP/的位置
        int endIdx = this.requsetinfo.indexOf("HTTP/");
        //③分子字符串
        this.uri = this.requsetinfo.substring(startIdx, endIdx);
        //获取？的位置
        int queryidx = this.uri.indexOf("?");
        if (queryidx >= 0) {//表示存在请求参数
            String[] urlArray = this.uri.split("\\?");
            queryStr = urlArray[1];
        }
        System.out.println("3.获取请求参数：如果Get已经获取，如果Post可能在请求体中");
        if (method.equals("post")) {
            String qstr = this.requsetinfo.substring(this.requsetinfo.lastIndexOf(CRLF)).trim();
            System.out.println(qstr+"--->");
            if (null == queryStr) {
                queryStr = qstr;
            } else {
                queryStr+="&"+qstr;
            }
        }
        System.out.println(method+"-->"+uri+"-->"+queryStr);
    }
}
