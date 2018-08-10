package Lesson1;

import java.util.ArrayList;

public class Type<T> {
    private T[] var;
    public Type(T[] type){
        var=type;
    }
    public T[] getMas(){
        return var;
    }
    public void changeMas(){
        T temp;
        temp=var[0];
        var[0]=var[1];
        var[1]=temp;
    }
    public void print(){
        for (int i = 0; i <var.length ; i++) {
            System.out.print(var[i]+" ");
        }
        System.out.println();
    }
    // Преобразование в ArrayList
    public void toArrayList(){
        ArrayList<T> out=new ArrayList<T>();
        for (int i = 0; i < var.length; i++) {
            out.add(var[i]);
        }
        System.out.println(out);
    }

}
