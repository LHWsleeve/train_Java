package Net_study01;

import java.net.InetSocketAddress;

/**
 * 端口：
 * 1.区分软件
 * 2.2哥字节0-65535 UDP TCP
 * 3.同一个协议端口不能冲突
 * 4.定义端口越大大越好
 *InetSocketAddress
 * 构造器：
 * 1.new InetSocketAddress("地址|域名",端口);
 *方法 getAddress/getPort
 */
public class PortTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getPort());
    }
}
