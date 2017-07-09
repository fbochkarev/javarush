package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 — «ноль«, 1 — «один«, 2 — «два»
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.

c:\\java\\test19.txt
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));


        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            String[] arr = line.split(" ");
            String word = "";

            for (int i = 0; i < arr.length; i++) {

                if (arr[i].matches("[-+]?\\d+") && (Integer.parseInt(arr[i]) >= 0) && (Integer.parseInt(arr[i]) <= 12)){


                        for (Map.Entry<Integer, String> entry : map.entrySet()) {
                            if (entry.getKey() == Integer.parseInt(arr[i]))
                                word = entry.getValue();

                        }

                    arr[i] = word;
                }
                System.out.print(arr[i] + " ");
            }
            System.out.println();


        }



        reader.close();
        bufferedReader.close();



    }
}
