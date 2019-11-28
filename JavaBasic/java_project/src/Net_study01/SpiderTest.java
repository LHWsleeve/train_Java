package Net_study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫原理
 */
public class SpiderTest {
    public static void main(String[] args) throws MalformedURLException {
        //获取URL
//        URL url = new URL("https://www.jd.com");
        URL url = new URL("https://www.dianping.com");

        //下载资源
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
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
