package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream f1 = new FileOutputStream(file1);
        FileInputStream f2 = new FileInputStream(file2);
        FileInputStream f3 = new FileInputStream(file3);

        byte[] buffer2 = new byte[f2.available()];
        while (f2.available() > 0){
            int count = f2.read(buffer2);
            f1.write(buffer2, 0, count);
        }

        byte[] buffer3 = new byte[f3.available()];
        while (f3.available() > 0){
            int count = f3.read(buffer3);
            f1.write(buffer3, 0, count);
        }

        f1.close();
        f2.close();
        f3.close();
    }
}
