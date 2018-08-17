package Lesson3;

import java.io.IOException;
import java.io.RandomAccessFile;

public class PageRead {
    public void read(String fileName, int pageNumber){
        RandomAccessFile raf=null;
        try{
            raf=new RandomAccessFile(fileName,"r");
            for (int i = 0; i < 1800; i++) {
                raf.seek(i+1800*(pageNumber-1));
                System.out.print((char)raf.read());
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
