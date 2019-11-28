package Big_SORM;

/**
 * 封装了java属性和get.set方法的源代码
 */
public class JavaFieldGetSet {
    /**
     * 属性源码信息
     */
    private String fieldInfo;
    /**
     * get方法源码信息
     */
    private String getdInfo;
    /**
     * set方法源码信息
     */
    private String setInfo;

    @Override
    public String toString() {
        System.out.println(fieldInfo);
        System.out.println(getdInfo);
        System.out.println(setInfo);
        return super.toString();
    }

    public JavaFieldGetSet() {
    }

    public JavaFieldGetSet(String fieldInfo, String getdInfo, String setInfo) {
        this.fieldInfo = fieldInfo;
        this.getdInfo = getdInfo;
        this.setInfo = setInfo;
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public String getGetdInfo() {
        return getdInfo;
    }

    public void setGetdInfo(String getdInfo) {
        this.getdInfo = getdInfo;
    }

    public String getSetInfo() {
        return setInfo;
    }

    public void setSetInfo(String setInfo) {
        this.setInfo = setInfo;
    }
}
