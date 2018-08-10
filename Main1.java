package Lesson1;

import java.sql.SQLOutput;

public class Main1 {
    public static void main(String[] args) {

        Integer[] mas1={1,2};
        String[] mas2={"a","b"};
        Integer[] mas3={1,2,3,4,5};
        String[] mas4={"a","b","d","e"};
        // Задача 1. Написать метод, который меняет два элемента массива местами (массив может быть любого
        //ссылочного типа);
        Type<Integer> obj1=new Type<Integer>(mas1);
        Type<String> obj2=new Type<String>(mas2);
        // Integer
        obj1.print();
        obj1.changeMas();
        obj1.print();
        // String
        obj2.print();
        obj2.changeMas();
        obj2.print();

        // Задача 2. Написать метод, который преобразует массив в ArrayList;
        Type<Integer> obj3=new Type<Integer>(mas3);
        obj3.toArrayList();
        Type<String> obj4=new Type<String>(mas4);
        obj4.toArrayList();

        // 3. Задача:
        //a. Даны классы Fruit -> Apple, Orange;
        //b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по
        //типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        //c. Для хранения фруктов внутри коробки можно использовать ArrayList;
        //d. Сделать метод getWeight(), который высчитывает вес коробки. Задать вес одного
        //фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не
        //важны);
        //e. Внутри класса Box сделать метод Compare, который позволяет сравнить текущую
        //коробку с той, которую подадут в Compare в качестве параметра. True – если их массы
        //равны, False в противоположном случае. Можно сравнивать коробки с яблоками и
        //апельсинами;
        //f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        //Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        //Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
        //объекты, которые были в первой;
        //g. Не забываем про метод добавления фрукта в коробку.
        Apple apple=new Apple();
        Orange orange=new Orange();
        Box<Apple> box1=new Box<Apple>();
        Box<Apple> box2=new Box<Apple>();
        Box<Orange> box3=new Box<Orange>();
        Box<Orange> box4=new Box<Orange>();

        // Добавление фруктов в коробки
        box1.add(apple);
        box1.add(apple);
        box1.add(apple);
        box1.add(apple);

        box2.add(apple);
        box2.add(apple);
        box2.add(apple);

        box3.add(orange);
        box3.add(orange);
        box3.add(orange);

        box4.add(orange);
        box4.add(orange);

        // Узнаем количество фруктов в каждой коробке

        System.out.println("В box1 фруктов: "+box1.getNumber());
        System.out.println("В box2 фруктов: "+box2.getNumber());
        System.out.println("В box3 фруктов: "+box3.getNumber());
        System.out.println("В box4 фруктов: "+box4.getNumber());
        // Узнаем вес коробок
        System.out.println("Вес box1= "+box1.getWeight());
        System.out.println("Вес box2= "+box2.getWeight());
        System.out.println("Вес box3= "+box3.getWeight());
        System.out.println("Вес box4= "+box4.getWeight());
        // Сравним коробки
        System.out.println(box2.compare(box3));
        System.out.println(box2.compare(box4));
        // Пересыпим в коробку из коробки
        box2.reload(box1,apple);
        box1.reload(box2,apple);
        box4.reload(box3,orange);
        System.out.println("Вес box1= "+box1.getWeight());
        System.out.println("Вес box2= "+box2.getWeight());
        System.out.println("Вес box3= "+box3.getWeight());
        System.out.println("Вес box4= "+box4.getWeight());


    }
}

