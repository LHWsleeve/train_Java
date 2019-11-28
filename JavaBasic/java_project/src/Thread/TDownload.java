package Thread;

import java.net.MalformedURLException;

public class TDownload extends Thread{
    private String url;
    private String name;

    private TDownload(String url, String name) {
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
        TDownload td1 = new TDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","1.jpg");
        TDownload td2 = new TDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","2.jpg");
        TDownload td3 = new TDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568463130701&di=13e80dc57d308ca17c37ab8541ed21c7&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718035532_sTdYY.thumb.700_0.jpeg","3.jpg");
    td1.start();
    td2.start();
    td3.start();
    }

}
