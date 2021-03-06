package com.javarush.task.task29.task2902;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Рефакторинг в соответствии с Naming and Code Convention 2
*/
public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        Solution solution = new Solution();
        String fileNameToBeOpenedByNotepad = Solution.getAbsolutePathToDefaultTxtFile().toString();
        Process notepad = Solution.getProcessStartNotepad(fileNameToBeOpenedByNotepad);
        notepad.waitFor();
    }

    public static Process getProcessStartNotepad(String fileName) throws IOException {
        String[] cmdArray = new String[]{"notepad.exe", fileName};
        return Runtime.getRuntime().exec(cmdArray);
    }

    public static Path getAbsolutePathToDefaultTxtFile() {
        URI uri = null;
        try {
            uri = Solution.class.getResource("file.txt").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return  Paths.get(uri);
    }
}
