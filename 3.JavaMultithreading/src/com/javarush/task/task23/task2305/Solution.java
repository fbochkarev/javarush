package com.javarush.task.task23.task2305;

/* 
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

/*    Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
    Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
    Инициализация всех данных должна происходить только в методе getTwoSolutions.*/

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();
        solution.innerClasses[0] = solution.new InnerClass();
        solution.innerClasses[1] = solution.new InnerClass();
        Solution solution1 = new Solution();
        solution1.innerClasses[0] = solution1.new InnerClass();
        solution1.innerClasses[1] = solution1.new InnerClass();

        Solution[]solutions = {solution,solution1};

        return solutions;
    }

    public static void main(String[] args) {

    }

}
