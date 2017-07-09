package com.javarush.task.task20.task2002;

import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
В файле your_file_name.tmp может быть несколько объектов JavaRush.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            String isUserPresent = this.users != null ? "yes" : "no";
            writer.println(isUserPresent);

            if (users != null){
                writer.println(users.size());
                if (users.size() > 0){
                    for (User x : users) {
                        writer.println(x.getFirstName());
                        writer.println(x.getLastName());
                        writer.println(format.format(x.getBirthDate()));
                        writer.println(x.isMale());
                        writer.println(x.getCountry().getDisplayedName());
                    }
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isUserPresent = reader.readLine();
            int userSize = Integer.parseInt(reader.readLine());
            if (isUserPresent.equals("yes")){
                this.users = new ArrayList<>();



                if(userSize > 0){
                    for (int i = 0; i < userSize; i++) {
                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setBirthDate(format.parse(reader.readLine()));
                        user.setMale(Boolean.parseBoolean(reader.readLine()));
                        String country = reader.readLine();
                        switch (country){
                            case "Ukraine" :
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "Russia" :
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            case "Other" :
                                user.setCountry(User.Country.OTHER);
                                break;
                        }

                        users.add(user);
                    }
                }
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
