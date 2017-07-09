package com.javarush.task.task28.task2801;

/*
Осваиваем switch
Реализуй логику метода switchTest:
1. Не используй условные операторы.
2. Используй 1 switch, у которого 2 case и 1 default.
3. Ожидаемый вывод:
Вывод для E1.A - "it's E1.A"
Вывод для E1.B - "it's E1.B"
Вывод для E1.C - "it's E1.C"
Вывод для E1.Y - "it's E1.Y"
Вывод для E2.D - "it's E2.D"
Вывод для E2.E - "it's E2.E"
Вывод для E2.F - "it's E2.F"
Вывод для всех других значений — «undefined«.


Требования:
1. Класс Solution должен содержать метод switchTest и enums E1, E2, E3.
2. Реализуйте метод switchTest, используя 1 switch, у которого 2 case и 1 default.
3. Вывод в консоль должен соответствовать условию задачи.
4. Использовать условные операторы нельзя.
*/
public class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* output
        it's E1.C
        undefined
        it's E2.D
         */
    }

    public static void switchTest(Enum obj) {
        //add your code here
        String enumType = obj.getClass().getSimpleName().toString();

        switch (enumType){
            case "E1":
                System.out.println(String.format("it's %s.%s", enumType, obj.name()));
                break;
            case "E2":
                System.out.println(String.format("it's %s.%s", enumType, obj.name()));
                break;
            default:
                System.out.println("undefined");
                break;

        }
    }
}
