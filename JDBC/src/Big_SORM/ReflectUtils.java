package Big_SORM;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射常用操作
 */
public class ReflectUtils {
    /**
     * 调用obj对象对应属性get方法
     * @param filename
     * @param obj
     * @return
     */
    public static Object invokeGet( String filename, Object obj){
        try {
            Class c = obj.getClass();
            Method m = c.getMethod("get"+StringUtils.firstChar2UpperCase(filename),null);
          return m.invoke(obj,null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    return null;
}
}
