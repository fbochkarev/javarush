package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект равен текущему(сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и текущего(не забудь что они могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
6. В классе Solution должен быть реализован метод hashCode.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (this == n) return true;

        if (!(n instanceof Solution)) return false;

//        if (n == null || n.getClass() != this.getClass()) {
//            return false;
//        }

        Solution s1 = (Solution)n;

        return s1.first == first && s1.last == last;
    }

    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result;
        result = prime * result + ((last == null) ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
