package com.sample.tcp.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther: dongchao
 * @data: 2023/4/12 21:45
 */
public class Tcp02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        // 使用字符缓冲输入流
        // InputStreamReader 把 inputStream 转为字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = reader.readLine();
        System.out.println(s);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("收到了");
        writer.newLine();// 输出流结束
        writer.flush();// 手动刷新

        // 关闭
        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();

    }
}
