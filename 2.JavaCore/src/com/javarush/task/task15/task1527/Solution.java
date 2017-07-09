package com.javarush.task.task15.task1527;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) — для чисел (дробные числа разделяются точкой)
alert(String value) — для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14
s.length()
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String afterQuestionMark = url.substring(url.indexOf("?")+1);
        String [] tokens = afterQuestionMark.split("(\\&+)|(\\?+)");

        ArrayList<String> objList = new ArrayList<String>();
        Pattern objMutch = Pattern.compile("^obj=.*");
        for(String a:tokens){
            if(!a.equals("")){
                Matcher matcher = objMutch.matcher(a);
                if(matcher.find()){ objList.add(a.substring(a.indexOf("=")+1)); }
                if(a.contains("=")){ System.out.print(a.substring(0,(a.indexOf("="))) +" "); }
                else {System.out.print(a+" ");}
            }
        }

        Pattern doublePattern = Pattern.compile("[0-9.]");
        Pattern stringPattern = Pattern.compile("[A-Za-z]");

        System.out.println();
        for(String a:objList){
            Matcher matcher = stringPattern.matcher(a);
            Matcher matcher1 = doublePattern.matcher(a);
            if(matcher.find()){alert(a);}
            else  if(matcher1.find()){alert(Double.parseDouble(a));}
        }

/*        for (String p : t) {


            if (p.contains("obj")) {
                String value = p.substring(p.indexOf("=") + 1);
                if (value.contains(".")) {
                    Double d = Double.parseDouble(value);
                    alert(d);
                }
                else alert(value);
            }
        }*/

/*        for (String p : t)
        {
            if (p.contains("="))
                System.out.print((p.substring(0, p.indexOf("="))) + " ");
            else System.out.print(p + " ");

        }*/


    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
