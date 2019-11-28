package Net_study01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:定位一个节点：计算机，路由，等等设备
 *InetAddress:多个静态方法
 * 1.getLocalHost:本记
 * 2.getByNmae：根据域名DNS|IP---》IP 解析地址
 * 两个成员方法
 * 1.getHostAddress：返回地址
 * 2.getHostName：返回计算机名
 */
public class IpTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());//返回本记IP
        System.out.println(addr.getHostName());//输出计算机名
    //根据域名得到InetAddress
        addr = InetAddress.getByName("www.shsxt.com");
        System.out.println(addr.getHostAddress());//返回163服务器的ip
        System.out.println(addr.getHostName());//输出www.163.com


    }

}
