package com.sample.tcp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 字节流
 * @auther: dongchao
 * @data: 2023/4/10 22:56
 */
public class Tcp01Client {
    public static void main(String[] args) throws IOException {
        // 根据IP，端口，生成一个socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端连接9999端口");
        // 创建输出流，把数据写入到管道中
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world".getBytes());
        System.out.println("已发送信息");
        // 设置写入结束标记
        socket.shutdownOutput();

        // 获取服务端回复信息
        System.out.println("客户端接收到了信息");
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;// 长度为-1，那么就读取完了
        while ((len = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,len));
        }

        // 关闭流
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端关闭");
    }
}
