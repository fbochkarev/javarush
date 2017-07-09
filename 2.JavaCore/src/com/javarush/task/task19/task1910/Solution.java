package com.javarush.task.task19.task1910;

/* 
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F

Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileReader = reader.readLine();
        String fileWriter = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(fileReader));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileWriter));

        String data;

        while (br.ready()){
            data = br.readLine();
            data = data.replaceAll("\\p{Punct}", "");
            bw.write(data);
        }

        br.close();
        bw.close();
    }
}
