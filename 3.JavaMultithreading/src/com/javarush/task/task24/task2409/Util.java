package com.javarush.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        //add your code here
        abstract class AbstractJeans implements Jeans{
            public AbstractJeans(int id, int length, int size, double price) {
            }

            protected AbstractJeans() {
            }

            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public String toString() {
                return "AbstractJeans{}";
            }

            @Override
            public int getId() {
                return 0;
            }

            @Override
            public double getPrice() {
                return 0;
            }

            @Override
            public String getTM() {
                return null;
            }
        }
        class Levis extends AbstractJeans{
            public Levis(int id, int length, int size, double price) {
            }
        }
        class Denim extends AbstractJeans{
            public Denim(int id, int length, int size, double price) {
            }
        }

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company ) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else
                if (Company.Denim == company) {
                    jeans = new Denim(id, length, size, price);
                } else {
                    jeans = new AbstractJeans(id, length, size, price) {
                        public String getTM() {
                            return company.fullName;
                        }
                    };
                }
            allJeans.add(jeans);
        }
        return allJeans;
    }

/*    2. В классе Util в методе getAllJeans добавь пропущенную часть java-кода:
        2.1) разберись в том, что уже есть в методе getAllJeans класса Util
        2.2) создай абстрактный class AbstractJeans от интерфейса Jeans с одним абстрактным методом, реализуй остальные методы
        2.3) создай классы Levis и Denim от AbstractJeans, реализуй оставшийся метод
        2.4) в классе AbstractJeans реализуй метод toString() (можешь воспользоваться Alt+Insert -> toString())
        2.5) метод toString класса AbstractJeans должен начинаться с имени сабкласса, например, Levis{id=1, length=34, size=6, price=150.0}


    Требования:
        1. Интерфейс Item должен быть создан в отдельном файле.
        2. Интерфейс Jeans должен расширять интерфейс Item и быть создан в отдельном файле.
        3. В интерфейсе Item должны присутствовать все методы перечисленные в условии.
        4. В классе Jeans должны присутствовать все методы перечисленные в условии.
        5. В методе getAllJeans класса Util должен быть создан локальный абстрактный класс AbstractJeans, поддерживающий интерфейс Jeans.
        6. В методе getAllJeans класса Util должен быть создан локальный класс Levis, унаследованный от класса AbstractJeans.
        7. В методе getAllJeans класса Util должен быть создан локальный класс Denim, унаследованный от класса AbstractJeans.*/

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis ("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;
        Company(String name) {
            this.fullName = name;
        }
    }
}
