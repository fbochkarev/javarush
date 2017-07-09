package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла — в allLines, из второго — в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader aL = new BufferedReader(new FileReader(reader.readLine()));
            BufferedReader fL = new BufferedReader(new FileReader(reader.readLine()));
            String line;

            while (!((line = aL.readLine()) == null) ){
                allLines.add(line);
            }

            while (!((line = fL.readLine()) == null)){
                forRemoveLines.add(line);
            }


        }catch (Exception e){

        }


        try {
            new Solution().joinData();
        }catch (CorruptedDataException e){
            System.out.println(e);
        }
    }

/*    В методе joinData:
    3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
    которые есть в forRemoveLines
    4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
    4.1. очистить allLines от данных
    4.2. выбросить исключение CorruptedDataException
    Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
    Не забудь закрыть потоки.*/

    public void joinData() throws CorruptedDataException {
        if (allLines.contains(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
        }
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
            return;
        }




        for (int i = 0; i < allLines.size(); i++) {
            for (int j = 0; j < forRemoveLines.size(); j++) {

                if(!allLines.get(i).equals(forRemoveLines.get(j))){
                    allLines.clear();
                    throw new CorruptedDataException();
                }

            }

        }

    }


}
