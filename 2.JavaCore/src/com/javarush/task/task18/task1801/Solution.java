package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //1. Ввести с консоли имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        //2. Найти максимальный байт в файле, вывести его на экран.
        ArrayList<Byte> byteList = new ArrayList<>();
        while (fileInputStream.available() > 0){
            Integer data  = fileInputStream.read();
            byteList.add(data.byteValue());
        }
        reader.close();
        Collections.sort(byteList);//сортировка по возрастанию
        if (byteList.size() > 0) { System.out.println(byteList.get(byteList.size() - 1)); }
        //3. Закрыть поток ввода-вывода.
        fileInputStream.close();
    }
}
