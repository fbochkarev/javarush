package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.*;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = args[0];
        /*String file = "c:\\java\\test19.txt";*/

        BufferedReader br = new BufferedReader(new FileReader(file));

        int day, month, year;
        String name = "";
        Calendar birthdayCalendar = new GregorianCalendar();


        while (br.ready()){
            String[] arr = br.readLine().split(" ");
            day = Integer.parseInt(arr[arr.length - 3]);
            month = Integer.parseInt(arr[arr.length - 2]);
            year = Integer.parseInt(arr[arr.length - 1]);
            birthdayCalendar.set(year, month - 1, day);


            if (arr.length > 4){
                name = arr[0] + " " + arr[1] + " " + arr[2];
            } else {
                name = arr[0];
            }

            PEOPLE.add(new Person(name, birthdayCalendar.getTime()));
        }


        reader.close();
        br.close();


    }
}
