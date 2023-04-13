package com.sample.tcp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 字节流
 * 客户端发送消息到服务端，服务端输出，之后服务端回复消息给客户端
 * @auther: dongchao
 * @data: 2023/4/10 22:13
 */
public class Tcp01Server {
    public static void main(String[] args) throws IOException {
        // 服务端监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在监听9999端口，等待连接。。。");
        // 生成一个socket
        Socket socket = serverSocket.accept();
        // 创建输入流，获取管道中的数据
        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024];
        int len = 0;// 长度为-1，那么就读取完了
        while ((len = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,len));
        }

        // 回复客户端，收到信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("yes Iknow".getBytes());
        // 设置写入结束标记
        socket.shutdownOutput();
        System.out.println("服务端发送了信息");
        // 关闭流
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
         

    }
}
