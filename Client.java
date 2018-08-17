package Lesson3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket=null;
    ByteArrayOutputStream os=new ByteArrayOutputStream();
    ObjectOutputStream oos=null;


    public Client() throws FileNotFoundException {
        try {

            socket=new Socket("localhost", 8000);
            System.out.println("Connected...");
            oos=new ObjectOutputStream(os);
            Student student=new Student();
            oos.writeObject(student);
            os.close();
            oos.close();
            byte[] byteArr=os.toByteArray();

            PrintWriter pw=new PrintWriter(socket.getOutputStream());
            pw.print(byteArr);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}