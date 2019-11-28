package Thread;

import java.net.MalformedURLException;

/**
 * 优先使用接口，方便共享资源
 * 避免单继承局限性
 */
public class IDownload implements Runnable{
    private String url;
    private String name;

    private IDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownload wd = new WebDownload();
        try {
            wd.download(url, name);
            System.out.println(name);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        IDownload td1 = new IDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","1.jpg");
        IDownload td2 = new IDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","2.jpg");
        IDownload td3 = new IDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","3.jpg");
        Thread t1 = new Thread(td1);
        Thread t2 = new Thread(td2);
        Thread t3 = new Thread(td3);
    t1.start();
    t2.start();
    t3.start();
    }

}
