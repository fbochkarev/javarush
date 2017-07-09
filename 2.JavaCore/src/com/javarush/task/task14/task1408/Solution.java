package com.javarush.task.task14.task1408;

/* 
1. Создать класс Hen.
1.1. Сделать его абстрактным.
1.2. Добавить в класс абстрактный метод int getCountOfEggsPerMonth().
1.3. Добавить в класс метод String getDescription(), который возвращает строку «Я — курица.«.
2. Создать класс RussianHen, который наследуется от Hen.
3. Создать класс UkrainianHen, который наследуется от Hen.
4. Создать класс MoldovanHen, который наследуется от Hen.
5. Создать класс BelarusianHen, который наследуется от Hen.
6. В каждом из четырех последних классов написать свою реализацию метода getCountOfEggsPerMonth.
Методы должны возвращать количество яиц в месяц от данного типа куриц.
7. В каждом из четырех последних классов написать свою реал
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if (country.equals(Country.RUSSIA)) hen = new RussianHen();
            else if (country.equals(Country.UKRAINE)) hen = new UkrainianHen();
            else if (country.equals(Country.MOLDOVA)) hen = new MoldovanHen();
            else if (country.equals(Country.BELARUS)) hen = new BelarusianHen();
            return hen;
        }
    }





}
