package com.javarush.task.task22.task2201;

/*      3. Реализуйте логику трех protected методов в ThisUncaughtExceptionHandler используя вызовы соответствующих методов согласно следующим шаблонам:


*/

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

//    в) RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return String.format(e.getClass().getSimpleName() + " : " + e.getCause() + " : " + t.getName());

    }

//    б) java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : TooShortStringSecondThreadException : 2#/**/

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return String.format(e.getCause() + " : " + e.getClass().getSimpleName() + " : " + t.getName());
    }

//    a) 1# : TooShortStringFirstThreadException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return String.format(t.getName() + " : " + e.getClass().getSimpleName() + " : " + e.getCause());
    }
}

