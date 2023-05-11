package com.stu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // 为服务器指定一个大于1024 的端口
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                System.out.println("等待接受客户端的连接：");
                Socket socket = serverSocket.accept();

                System.out.println("连接成功");

                //读取客户端发送的信息
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = in.readLine();
                System.out.println("客户端发来的信息：" + str);

                //向客户端发送消息
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                out.println("hello i am server");
                in.close();
                out.close();
                socket.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
