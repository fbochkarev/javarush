package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 12.06.2017.
 */

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String message;
        while (true){
            try {
                message = reader.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return message;
    }

    public static int readInt(){
        int count;
        while (true){
            try {
                count = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e){
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }

        }

        return count;
    }
}
