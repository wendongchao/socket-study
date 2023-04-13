package com.sample.fileupload;

import java.io.*;

/**
 * @auther: dongchao
 * @data: 2023/4/12 22:28
 */
public class StreamUtils {

    /**
     * 输入流数据转为字节数组
     * @param inputStream
     * @author dongchao
     * @return byte
     * @date 2023/4/12 23:01
     */
    public static byte[] streamToByteArray(InputStream inputStream) throws IOException {
        // 创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            bos.write(buf,0,len);// 读取到的数据写入到输出流中
        }
        byte[] array = bos.toByteArray();// 输出流数据转为字节数组
        bos.close();
        return array;
    }

    /**
     * 把输入流转为字符串
     * @param inputStream
     * @author dongchao
     * @return String
     * @date 2023/4/12 22:42
     */
    public static String streamToString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        // readLine有结束标记，当读取到空时，会结束，结束标记需要前面输出流设置
        while ((line = reader.readLine()) != null) {
            builder.append(line+"\r\n");
        }
        return builder.toString();
    }
}
