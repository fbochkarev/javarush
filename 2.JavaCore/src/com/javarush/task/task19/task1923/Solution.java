package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = args[0];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));

        String file2 =  args[1];
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));

        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            String[] arr = line.split(" ");
            String lineWrite = "";

            for (String x: arr) {


                if (x.matches(".+[0-9].+")){

                    bufferedWriter.write(x + " ");
                }

            }
        }

        reader.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
