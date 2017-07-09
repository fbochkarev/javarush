package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром — именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
‘,’=44, ‘s’=115, ‘t’=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        /*ArrayList<Character> list = new ArrayList<>();*/
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        char[] list = new char[fis.available()];
        byte[] data = new byte[fis.available()];
        while (fis.available() > 0){

            fis.read(data);
            list = new String(data).toCharArray();
        }

        int count = 0;
        for (char x : list) {
            for (char x1 : list) {
                if (x == x1){
                    count++;
                    treeMap.put(x, count);

                }
            }
            count = 0;
        }

        for (Map.Entry entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        /*reader.close();*/
        fis.close();

    }
}
