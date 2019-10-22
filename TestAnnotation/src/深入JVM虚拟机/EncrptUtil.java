package 深入JVM虚拟机;

import java.io.*;

/**
 * 加密工具类
 */
public class EncrptUtil {
    public static void encrp(String src, String dest) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos =new FileOutputStream(dest);
            int temp = -1;
            while((temp=fis.read())!=-1){
                fos.write(temp^0xff);//取反操作
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                fis.close();
            }
            if (fos!=null){
                fos.close();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        encrp("C:\\Users\\liuha\\Documents\\GitHub\\train_Java/HelloWorld.class",
                "C:\\Users\\liuha\\Documents\\GitHub\\train_Java\\temp/HelloWorld.class");
    }
}
