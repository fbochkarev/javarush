package com.javarush.task.task17.task1703;

import sun.org.mozilla.javascript.internal.Synchronizer;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки
1. Класс Note будет использоваться нитями. Поэтому сделай так, чтобы обращения к листу notes блокировали мьютекс notes, не this
2. Все System.out.println не должны быть заблокированы (синхронизированы), т.е. не должны находиться в блоке synchronized
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class Note {

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            synchronized (notes){
                System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
                notes.add(index, note);
                System.out.println("Уже добавлена заметка [" + note + "]");
            }
        }

        public void removeNote(int index) {
            synchronized (notes) {
                System.out.println("Сейчас будет удалена заметка с позиции " + index);
                String note = notes.remove(index);
                System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
            }
        }
    }

}
