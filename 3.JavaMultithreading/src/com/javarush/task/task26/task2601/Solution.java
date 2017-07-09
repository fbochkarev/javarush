package com.javarush.task.task26.task2601;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5


Требования:
1. Программа не должна выводить текст в консоль.
2. Программа не должна считывать данные с консоли.
3. Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
4. Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности от его медианы.
*/
public class Solution{

    public static void main(String[] args) {

/*        Integer[] mass = new Integer[] {13, 8, 15, 5, 17};

        System.out.println(Arrays.toString(sort(mass)));*/

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        List<Integer> list = Arrays.asList(array);

        //Находим медиану

        final double mediana;
        if (array.length % 2 == 0)
            mediana = ((double)array[array.length/2-1]+(double)array[array.length/2])/2;
        else
            mediana = array[array.length/2];

        //Сортируем

        Comparator<Integer> compareByDistance = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - (int)mediana) - Math.abs(o2 - (int)mediana);
            }
        };

        Collections.sort(list, compareByDistance);

        array = ( Integer [] ) list.toArray( new Integer[]{});

        return array;
    }


}
