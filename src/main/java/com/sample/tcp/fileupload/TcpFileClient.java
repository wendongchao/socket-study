package com.sample.tcp.fileupload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 上传文件
 * @auther: dongchao
 * @data: 2023/4/12 23:44
 */
public class TcpFileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        String filePath = "abc.png";
        // 使用输入流从磁盘中读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        // 创建缓存输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        // 将数据写入到通道中
        bos.write(bytes);
        bis.close();// 文件输入流关闭，只需要关闭外面的流，不用管里面的流
        // 设置输出流结束标志
        socket.shutdownOutput();

        // 创建输入流，从通道中获取数据
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bos.close();
        socket.close();


    }
}
