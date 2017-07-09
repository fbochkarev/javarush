package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить только цифры.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.
Выведи модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        /*String[] arr = result.split("(?<=\\G.{1})");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].matches("[0-9]*")) {
                list.add(arr[i]);

            }
        }
        String[] arr2 = list.toArray(new String[list.size()]);

        String test = "";
        for (int i = 0; i < arr2.length; i++) {
            test = test + arr2[i];
        }
        result = test;
        System.out.println(result);*/
        result = outputStream.toString().replaceAll("\\D","");

        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
