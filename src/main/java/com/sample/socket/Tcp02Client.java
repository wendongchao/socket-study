package com.sample.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 字符流
 * @auther: dongchao
 * @data: 2023/4/12 21:46
 */
public class Tcp02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        // 使用字符缓冲输出流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("hello world 字符流");
        // 插入换行符，标识写入内容结束
        writer.newLine();
        // 把缓冲中的内容写入到通道中
        writer.flush();

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = reader.readLine();
        System.out.println(s);

        reader.close();
        writer.close();
        socket.close();


    }
}
