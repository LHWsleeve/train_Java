package Server_study05;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * 封装请求协议
 * 目标：封装请求参数为Map
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
    //存储参数
    private Map<String, List<String>> parameterMap;

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }


    public Request(InputStream is) {
        parameterMap = new HashMap<>();
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
        this.uri = this.requsetinfo.substring(startIdx, endIdx).trim();
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
        //转成Map
        converMap();
    }
    //处理请求参数，为Map
    //转成Map fav=1&fav=2&uname=shsxt&age=18&others=
    private void converMap(){
        //分割字符串&
        String[] keyValues = this.queryStr.split("&");
        for (String qury:keyValues){
            //再次分割字符串 =
            String[] kv= qury.split("=");
            kv = Arrays.copyOf(kv,2);
            //获取key和value
            String key = kv[0];
            String value = kv[1]==null?null:decode(kv[1],"UTF-8");
            //存储到Map
            if (!parameterMap.containsKey(key)){//map中没有这个key，第一次填入
                parameterMap.put(key,new ArrayList<>());
            }
            parameterMap.get(key).add(value);
        }
    }
    private String  decode(String value, String enc){

        try {
            return java.net.URLDecoder.decode(value,enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 通过name（key）获取多个值
     * @param key
     * @return
     */
    public String[] getparameterValues(String key){
        List<String > values = this.parameterMap.get(key);
        if (values==null||values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }

    /**
     * 通过name（key）获取对应的一个值
     * @param key
     * @return
     */
    public  String getParameter(String key){
        String[] values = getparameterValues(key);
        return values==null?null:values[0];
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getQueryStr() {
        return queryStr;
    }
}
