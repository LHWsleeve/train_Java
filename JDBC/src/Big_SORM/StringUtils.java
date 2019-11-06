package Big_SORM;

/**
 * 封装字符串常用操作
 */
public class StringUtils {
    /**
     * 首字母转大写
     * @param str
     * @return
     */
    public static String firstChar2UpperCase(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);


    }
}
