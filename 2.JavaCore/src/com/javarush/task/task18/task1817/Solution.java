package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);
        int countAll = 0;
        int countSpace = 0;

        while (inputStream.available() > 0){
            int data = inputStream.read();
            countAll++;
            if (data == 32){
                countSpace++;
            }
        }

        double result = (double)countSpace / (double)countAll * 100;

        System.out.println(String.format("%.2f",result));

        inputStream.close();

    }
}
