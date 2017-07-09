package com.javarush.task.task19.task1906;

/* 
Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.

Пример:
второй байт, четвертый байт, шестой байт и т.д.

Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        String file1 = reader.readLine();

        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file1);
        List<Integer> list = new ArrayList<Integer>();

        while (fr.ready()){
            int data = fr.read();
            list.add(data);
        }

        for (int i = 1; i < list.size(); i = i + 2) {
            fw.write((char)(int)list.get(i));
        }

        reader.close();
        fr.close();
        fw.close();
    }
}
