package com.topyfine.designpattern.java8new;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/13 22:05
 */
public class SocketTest {
    @Test
    public void testSocket() throws IOException {
        // 客户端
        Socket socket = new Socket("time-a.nist.gov", 13);
        Scanner scanner = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8.name());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    @Test
    public void testInet() throws IOException {
        // 获取本地主机地址
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getCanonicalHostName());
        // 获取localhost地址，总是返回127.0.0.1
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost.getHostAddress());
        // 获取域名对应的多个ip地址
        InetAddress[] addresses = InetAddress.getAllByName("cn.bing.com");
        Stream.of(addresses).forEach(ad -> System.out.println(ad.getHostName() + " <<< " + ad.getHostAddress()));
    }
}
