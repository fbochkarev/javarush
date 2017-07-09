package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String f1 = reader.readLine();
        String f2 = reader.readLine();

        FileOutputStream file1 = new FileOutputStream(f1);
        FileInputStream file1_1 = new FileInputStream(f1);
        FileInputStream file2 = new FileInputStream(f2);

        byte[] buffer = new byte[file2.available()];
        while (file2.available() > 0){
            int count = file2.read(buffer);
            file1.write(buffer, 0, count);
        }

        byte[] buffer2 = new byte[file1_1.available()];
        while (file1_1.available() > 0){
            int count = file1_1.read(buffer2);
            file1.write(buffer2, 0, count);
        }

        reader.close();
        file1.close();
        file1_1.close();
        file2.close();

    }
}
