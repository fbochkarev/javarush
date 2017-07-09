package com.javarush.task.task19.task1909;

/* 
Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки «.» на знак «!«.
Результат вывести во второй файл.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileReader = reader.readLine();
        String fileWriter = reader.readLine();

        BufferedReader br = new BufferedReader(new FileReader(fileReader));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileWriter));

        String data;

        while (br.ready()){
            data = br.readLine();
            data = data.replace(".","!");
            bw.write(data);


        }

        reader.close();
        br.close();
        bw.close();
    }
}
