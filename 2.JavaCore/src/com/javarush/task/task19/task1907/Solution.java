package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.
c:\\java\\test19.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileReader fr = new FileReader(file);

        String test = "";


        while (fr.ready()){
            test = test + (char)fr.read();
        }


        String[] words = test.split("[,;:.!?\\s]+");

        int counts = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("world") || words[i].equals("World")){
                counts++;
            }
        }

        System.out.println(counts);

        reader.close();
        fr.close();

    }
}
