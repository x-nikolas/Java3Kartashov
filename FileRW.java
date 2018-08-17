package Lesson3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileRW {
    FileInputStream in=null;
    FileOutputStream out=null;

    public void write(){
        try {
            out = new FileOutputStream("myFile1.txt");
            out.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            out.close();
            } catch (IOException e){
                e.printStackTrace();
            }
          }
    }
    public void read(String fileName, byte[] byteMas){
        try {
            in = new FileInputStream(fileName);
            in.read(byteMas);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (byte o: byteMas) {
            System.out.println(o);
        }
    }
}
