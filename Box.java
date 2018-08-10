package Lesson1;

import java.util.ArrayList;

public class Box<T extends Fruits> {
    ArrayList<T> box=new ArrayList<T>();
    private float weight;

    public void add(T fruit){
        box.add(fruit);
        this.weight=fruit.getWeight();
    }
    public int getNumber(){
        return box.size();
    }
    public float getWeight(){
        return weight*box.size();
    }

    public boolean compare (Box anotherBox){
        return this.weight*box.size()==anotherBox.getWeight();
    }
    public void reload(Box<T> anotherbox, T fruit){

        for (int i = 0; i <anotherbox.box.size() ; i++) {
            box.add(fruit);
        }
        anotherbox.box.clear();
    }

}
