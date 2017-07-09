package com.javarush.task.task26.task2602;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Был бы ум - будет и успех
Солдаты всегда строились, строятся и будут строиться по убыванию роста.
Отсортируй солдат, предварительно подумав, что лучше использовать при таких условиях — Comparable или Comparator.


Требования:
1. Класс Soldier должен содержать приватные поля String name и int height.
2. Класс Soldier должен содержать конструктор с двумя параметрами String name и int height.
3. Подумай, что лучше использовать, и реализуй Comparable или Comparator.
4. Класс Soldier должен содержать метод compareTo(Soldier solder).
5. Метод compareTo(Soldier solder) должен сравнивать двоих солдат, учитывая только их рост. Сравнивать объекты нужно с учетом убывания роста солдат.
*/
public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable<Soldier>{
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public int compareTo(Soldier o) {
            return o.height - this.height;
        }
    }
}
