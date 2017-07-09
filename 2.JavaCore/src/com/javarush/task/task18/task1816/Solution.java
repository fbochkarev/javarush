package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.
*/

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;

        FileInputStream inputStream = new FileInputStream(args[0]);
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if ((data > 64) && (data < 91) || (data > 96) && (data < 123)){

                count++;
            }
        }
        System.out.println(count);



        inputStream.close();
    }
}
