package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*Последовательный вывод файлов
        1. Разберись, что делает программа.
        2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
        3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
        интерфейс ReadFileInterface (Подумай, что больше подходит — Thread или Runnable).
        3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
        3.2. Метод getFileContent должен возвращать содержимое файла.
        3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
        4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить последовательный вывод файлов.
        4.1. Для этого добавь вызов соответствующего метода.

        Ожидаемый вывод:
        [все тело первого файла]
        [все тело второго файла]*/

/*public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут


    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, FileNotFoundException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName) throws FileNotFoundException;

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fileName;
        private String fileContent;

        BufferedReader reader;
        List<String> list = new ArrayList<>();

        public void setFileName(String fullFileName)
        {
            this.fileName = fullFileName;
        }
        public String getFileContent()
        {
            String line = null;

            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));

                while ((line = reader.readLine()) != null){
                    fileContent += line + " ";
                }



            } catch (Exception e){

            }

            return fileContent;
        }

        @Override
        public void start() {

        }

        @Override
        public void run() {

            String line;
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    fileContent = fileContent + " " + line;
                }
                bufferedReader.close();
            } catch (IOException e) {

            }
        }
    }
}*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName=reader.readLine();
            secondFileName=reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public static interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String fileData="";

        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        public String getFileContent() {
            return fileData;
        }

        public void run() {
            String line;
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    fileData = fileData + " " + line;
                }
                bufferedReader.close();
            } catch (IOException e) {}
        }
    }
}
