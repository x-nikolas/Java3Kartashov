package Lesson3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    private ServerSocket server=null;
    private Socket socket=null;
    private final int PORT=8000;

    public void start(){



        try {
            server=new ServerSocket(PORT);
            System.out.println("Сервер запущен...");
            socket=server.accept();
            System.out.println("Клиент подключен...");
            Scanner sc=new Scanner(socket.getInputStream());
            PrintWriter pw=new PrintWriter(socket.getOutputStream());



                try {
                    byte [] mas=new byte[1000000];
                    ByteArrayInputStream is=new ByteArrayInputStream(mas);
                    ObjectInputStream ois=new ObjectInputStream(is);
                    Student student=(Student) ois.readObject();
                    System.out.println(student.getA());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }



        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Проблемы при создании сервера");;
        } finally {
            try{
                server.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
