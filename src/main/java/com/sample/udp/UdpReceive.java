package com.sample.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 接收端
 * @auther: dongchao
 * @data: 2023/4/14 22:31
 */
public class UdpReceive {
    public static void main(String[] args) throws IOException {
        // 创建一个接收端socket
        DatagramSocket socket = new DatagramSocket(9999);

        // 创建DatagramPacket作为数据传输的载体
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        // 接收数据，没有数据时会程序会阻塞在这里
        socket.receive(packet);

        // 获取数据
        byte[] data = packet.getData();
        int length = packet.getLength();
        String s = new String(data, 0, length);
        System.out.println(s);

        // 回复消息
        data = "知道了".getBytes();
        length = data.length;
        packet = new DatagramPacket(data,length, InetAddress.getLocalHost(),9998);
        socket.send(packet);
        // 关闭流
        socket.close();
    }
}
