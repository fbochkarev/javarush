package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.awt.*;
import java.io.File;

/**
 * Created by User on 24.02.2017.
 *         4. Этот метод должен:
 4.1. Для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG — JpgReader;
 4.2. Если передан неправильный параметр, то выбрасывать исключение IllegalArgumentException(«Неизвестный тип картинки«).
 */

public class ImageReaderFactory {


    public static ImageReader getImageReader(ImageTypes fileName) {

            if (fileName == ImageTypes.JPG) {
                return new JpgReader();
            } else if (fileName == ImageTypes.BMP) {
                return new BmpReader();
            } else if (fileName == ImageTypes.PNG) {
                return new PngReader();
            } else {
                throw  new  IllegalArgumentException("Неизвестный тип картинки");
            }
    }

}

/*    private static String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".")+1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }*/




