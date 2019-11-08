package Big_SORM;

/**
 * 管理配置信息
 */
public class Configuration {
    /**
     * 驱动类
     */
    private String diver;
    /**
     * jdbc的url
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String user;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 正在使用的数据库
     */
    private String usingDB;
    /**
     * 项目源码路径
     */
    private String srcPath;
    /**
     * 扫描生成java类的包
     */
    private String poPackage;
    /**
     * 项目使用查询类是哪一个类
     */
    private String querClass;

    public String getQuerClass() {
        return querClass;
    }

    public void setQuerClass(String querClass) {
        this.querClass = querClass;
    }

    public Configuration() {
    }

    public Configuration(String diver, String url, String user, String pwd, String usingDB, String srcPath, String poPackage, String querClass) {
        this.diver = diver;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
        this.usingDB = usingDB;
        this.srcPath = srcPath;
        this.poPackage = poPackage;
        this.querClass = querClass;
    }

    public java.lang.String getDiver() {
        return diver;
    }

    public void setDiver(java.lang.String diver) {
        this.diver = diver;
    }

    public java.lang.String getUrl() {
        return url;
    }

    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    public java.lang.String getUser() {
        return user;
    }

    public void setUser(java.lang.String user) {
        this.user = user;
    }

    public java.lang.String getPwd() {
        return pwd;
    }

    public void setPwd(java.lang.String pwd) {
        this.pwd = pwd;
    }

    public java.lang.String getUsingDB() {
        return usingDB;
    }

    public void setUsingDB(java.lang.String usingDB) {
        this.usingDB = usingDB;
    }

    public java.lang.String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(java.lang.String srcPath) {
        this.srcPath = srcPath;
    }

    public java.lang.String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(java.lang.String poPackage) {
        this.poPackage = poPackage;
    }
}

