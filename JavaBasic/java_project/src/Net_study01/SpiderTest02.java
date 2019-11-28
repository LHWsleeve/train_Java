package Net_study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫原理+模拟浏览器
 *
 */
public class SpiderTest02 {
    public static void main(String[] args) throws MalformedURLException {
        //获取URL
        URL url = new URL("https://www.dianping.com");

        //下载资源
        try {
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String msg = null;
            while (null!=(msg=br.readLine())){
                System.out.println(msg);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //分析
        //处理


    }
}
