package Lesson3;

import java.util.Scanner;

public class Main {

    private static byte[] byteMas=new byte[63];

    public static void main(String[] args) {

        // 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        FileRW fr=new FileRW();
        fr.read("myFile1.txt", byteMas);
        // 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
        FiveToOne fto=new FiveToOne();
        fto.doIt("myFile1.txt","myFile2.txt","myFile3.txt","myFile4.txt","myFile5.txt");
        // 3. Написать консольное приложение, которое умеет постранично читать текстовые файлы
        //(размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа
        //выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться
        //дольше 10 секунд, а чтение – занимать свыше 5 секунд.
        Scanner sc=new Scanner(System.in);
        while (true) {
            Long t=System.currentTimeMillis();
            System.out.println("Введите номер страницы (0-выход)");
            int in=sc.nextInt();
            if (in==0) break;

            PageRead pr = new PageRead();
            pr.read("BigFile.txt", in);
            System.out.println("Время выполнения: "+(System.currentTimeMillis()-t)+" мс.");
        }

        // Дополнительное ДЗ - не понятно....
//        MyServer myServer=new MyServer();
//        myServer.start();
    }
}
