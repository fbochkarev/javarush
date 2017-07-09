package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1

c:\\java\\test19.txt
*/

import java.io.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileReader = reader.readLine();
        String fileWriter = reader.readLine();


        BufferedReader fr = new BufferedReader(new FileReader(fileReader));
        BufferedWriter fw = new BufferedWriter(new FileWriter(fileWriter));

        String test = "";
        while(fr.ready()){
            int data = fr.read();
                test = test + (char)data;
        }

        String[]work = test.split("[\\s]+");
        String test1 = "";

        for (int i = 0; i < work.length; i++) {
            if (work[i].matches("[0-9]*")) {
                test1 = test1 + work[i] + " ";
                System.out.println(work[i]);
            }

        }

        fw.write(test1);

        reader.close();
        fr.close();
        fw.close();


    }
}
