package com.sample.udp;

import java.io.IOException;
import java.net.*;

/**
 * 发送端
 * @auther: dongchao
 * @data: 2023/4/14 22:31
 */
public class UdpSend {
    public static void main(String[] args) throws IOException {
        // 创建发送端
        // 因为DatagramSocket既可以作为发送端工具，也可以作为接收端工具
        // 所以在发送端时也需要指定端口，方便接收端回复消息能找到端口
        // 那么发送端发送消息时，也需要指定接收端的端口
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] bytes = "hello 你好".getBytes();
        int length = bytes.length;
        // 创建DatagramPacket作为数据载体，并制定IP，端口
        DatagramPacket packet = new DatagramPacket(bytes,length, InetAddress.getLocalHost(),9999);
        // 发送数据
        socket.send(packet);

        // 接收返回的消息
        socket.receive(packet);
        bytes = packet.getData();
        length = packet.getLength();
        String s = new String(bytes, 0, length);
        System.out.println(s);


        // 关闭流
        socket.close();
    }
}
