package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = args[0];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));

        String file2 = args[1];
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        List<String> list = new ArrayList<>();


        while (bufferedReader.ready()){
            String[] arr = bufferedReader.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length() > 6) {


                    list.add(arr[i]);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if ( i == (list.size() - 1))
                bufferedWriter.write(list.get(i));
            else bufferedWriter.write(list.get(i) + ",");
        }

        reader.close();
        bufferedReader.close();
        bufferedWriter.close();

    }
}
