package com.sample.tcp.fileupload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther: dongchao
 * @data: 2023/4/12 23:44
 */
public class TcpFileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        // 创建缓冲输入流，从通道中读取数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String filePath = "aaa.png";
        // 创建缓冲输出流，把数据写入到磁盘中
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);
        bos.close();

        // 创建缓存输出流，回复客户端
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("已经收到");
        writer.flush();// 把缓冲内容刷新到通道中
        socket.shutdownOutput();// 设置结束标志

        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();

    }
}
