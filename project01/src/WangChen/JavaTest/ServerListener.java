package WangChen.JavaTest;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread{
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while(true){
                Socket socket = serverSocket.accept();
                JOptionPane.showMessageDialog(null,"有客户端连接到了本机端口");
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManger.getChatManger().add(cs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
