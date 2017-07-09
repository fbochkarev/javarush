package com.javarush.task.task14.task1408;

/**
 * Created by User on 12.02.2017.
 */
public class UkrainianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 15;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
