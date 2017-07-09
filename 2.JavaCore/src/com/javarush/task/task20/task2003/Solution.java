package com.javarush.task.task20.task2003;

import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут — http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.


Требования:
1. Метод fillInPropertiesMap должен считывать данные с консоли.
2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.

c:\\java\\test.txt
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties prop = new Properties();


    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fis = new FileInputStream(file);
        load(fis);
        reader.close();
        fis.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод

        prop.putAll(properties);
        prop.store(outputStream, null);

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.load(inputStream);

        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            properties.put(key, value);
        }
    }

    public static void main(String[] args) {


    }
}
