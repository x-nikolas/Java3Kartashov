package Lesson3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Vector;

public class FiveToOne {
    SequenceInputStream seq =null;
    FileOutputStream out=null;
    Vector files=new Vector();

    public void doIt(String name1, String name2,String name3,String name4,String name5){
        try{
            files.addElement(new FileInputStream(name1));
            files.addElement(new FileInputStream(name2));
            files.addElement(new FileInputStream(name3));
            files.addElement(new FileInputStream(name4));
            files.addElement(new FileInputStream(name5));
            seq=new SequenceInputStream(files.elements());
            out=new FileOutputStream("output.txt");
            int sr=seq.read();
            while (sr!=-1){
                out.write(sr);
                sr=seq.read();
            }

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
