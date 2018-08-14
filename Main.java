package Lesson2;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Подключаемся к базе данных
        Class.forName("org.sqlite.JDBC");
        Connection conn;
        conn=DriverManager.getConnection("jdbc:sqlite:Lesson2.db");
        Statement stmt=conn.createStatement();
        // Задача 1
        int result=stmt.executeUpdate("create table if not exists table2" +
                "( id integer primary key autoincrement not null," +
                "prodid integer unique," +
                "title string," +
                "cost integer );");
        System.out.println(result);
        // Конец задачи 1

        // Задача 2
        // Удаление данных из таблицы
        conn.setAutoCommit(false);
        PreparedStatement ps=conn.prepareStatement("delete from table2 where id=?");
        for (int i = 1; i <=1000 ; i++) {
            ps.setInt(1,i);
            ps.addBatch();
        }
        ps.executeBatch();
        conn.setAutoCommit(true);
        // Создание таблицы
        conn.setAutoCommit(false);
        ps=conn.prepareStatement("insert into table2 (id, prodid,title,cost) values (?,?,?,?);");
        for (int i = 1; i <=1000 ; i++) {
            ps.setInt(1,i);
            ps.setInt(2,i);
            ps.setString(3,"товар"+i);
            ps.setInt(4,10*i);
            ps.addBatch();
        }
        ps.executeBatch();
        conn.setAutoCommit(true);
        // Конец задачи 2

        // Задача 3

        Scanner scan=new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду.");
            String answer=scan.nextLine();
            String[] target=answer.split(" ", 2);

                if (target[0].equals("/цена")) {
                    try {
                        ResultSet rs = stmt.executeQuery("SELECT cost FROM table2 where title = " + "'"+target[1]+"'");
                        System.out.println("Цена товара: "+rs.getString(1));
                    } catch (SQLException e) {
                        System.out.println("Такого товара нет");
                    }
                }
            // Задача 4.
            if (target[0].equals("/сменитьцену")) {
                    String[] targetNew=target[1].split(" ",2);
                try {
                    int res = stmt.executeUpdate("update table2 set cost = "+targetNew[1]+" where title = '"+targetNew[0]+"'");
                } catch (SQLException e) {
                    System.out.println("Неверная команда");
                }
            }
            // Задача 5.
//            Вывести товары в заданном ценовом диапазоне. Консольная команда: «/товарыпоцене 100
//            600».
            if (target[0].equals("/товарыпоцене")) {
                String[] targetNew=target[1].split(" ",2);
                try {
                    ResultSet rs = stmt.executeQuery("SELECT title FROM table2 where cost >= "+targetNew[0]+
                            " and cost <= "+targetNew[1]);
                        while (rs.next()) {
                            System.out.println("Подходящий товар: " + rs.getString(1));
                        }
                } catch (SQLException e) {
                    System.out.println("Ошибка");
                }
            }

            // Выход
            if (target[0].equals("выход")) {
                System.out.println("Bye");
                    break;
            }
        }

        // Закрываем соединение
        conn.close();

    }
}
