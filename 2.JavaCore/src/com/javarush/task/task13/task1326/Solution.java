package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
c:\\java\\test.txt
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/*
        InputStream inputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while(inputStream.available() > 0){
            int data = inputStream.read();
            *//**//*
                *//*System.out.print((char)data);*//*
            if (data % 2 == 0)
                list.add(data);
        }

        int[] intArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            intArray[i] = list.get(i);
        }


        for (int j = 0; j < intArray.length; j++)
            for (int k = 0; k < intArray.length - 1; k++) {
                if (intArray[k] > intArray[k + 1]) {
                    int temp = intArray[k];
                    intArray[k] = intArray[k + 1];
                    intArray[k + 1] = temp;
                }
            }

        for (int i = 0; i < intArray.length; i++) {

            System.out.println(intArray[i]);
        }
        inputStream.close();
        reader.close();
        */
        Scanner sc = new Scanner(new File(reader.readLine()));
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            int data = sc.nextInt();
            if (data % 2 == 0)
                list.add(data);
        }
        sc.close();
    }
}
