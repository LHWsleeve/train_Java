package Thread;

import java.net.MalformedURLException;
import java.util.concurrent.*;

/**
 *实现callable接口，重写call方法
 */
public class CDownload implements Callable<Boolean> {
    private String url;
    private String name;

    private CDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownload wd = new WebDownload();
        try {
            wd.download(url, name);
            System.out.println(name);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownload td1 = new CDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","1.jpg");
        CDownload td2 = new CDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","2.jpg");
        CDownload td3 = new CDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","3.jpg");

        ExecutorService ser = Executors.newFixedThreadPool(3);
        Future<Boolean> result1 = ser.submit(td1);
        Future<Boolean> result2 = ser.submit(td2);
        Future<Boolean> result3 = ser.submit(td3);
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println(r3);
    }

}
