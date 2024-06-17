package com.cookandroid.fdfood;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class FileManager {

    // 파일을 생성하는 메서드
    public static void createFile(Context context, String fileName) {
        try {
            File file = new File(context.getFilesDir(), fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // 파일을 열고 내용을 반환하는 메서드
    public static String readTextFromFile(Context context, String fileName) {
        StringBuilder content = new StringBuilder();

        try {
            FileInputStream fis = context.openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    // 파일에 내용을 추가하는 메서드
    public static void appendTextToFile(Context context, String fileName, String text) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_APPEND);
            fos.write(text.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 특정 문자열을 포함하는 줄을 삭제하는 메서드
    public static void deleteLinesContainingText(Context context, String fileName, String searchText) {
        try {
            File originalFile = new File(context.getFilesDir(), fileName);
            File tempFile = new File(context.getFilesDir(), "temp.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(originalFile)));
            FileOutputStream writer = new FileOutputStream(tempFile);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] infos = line.split(" ");
                if (infos.length >= 2 && !infos[1].contains(searchText)) {
                    writer.write((line + "\n").getBytes());
                }
            }

            reader.close();
            writer.close();

            // 기존 파일 삭제
            originalFile.delete();

            // 임시 파일을 기존 파일명으로 변경
            tempFile.renameTo(originalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //평점별로 정렬해주는 메소드
    public static String getSortedScoresAsString(Context context, String fileName) {
        StringBuilder sortedScores = new StringBuilder();

        try {
            FileInputStream fis = context.openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            List<String[]> scores = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                scores.add(line.split(" "));
            }

            // 점수를 기준으로 내림차순 정렬
            Collections.sort(scores, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Double.compare(Double.parseDouble(o2[0]), Double.parseDouble(o1[0]));
                }
            });

            for (String[] score : scores) {
                for(int i=0;i<2;i++){
                    sortedScores.append(score[i]).append(" ");
                }
                sortedScores.append("\n");
                for(int i=2;i<score.length;i++){
                    sortedScores.append(score[i]).append(" ");
                }
                sortedScores.append("\n");
                sortedScores.append("----------------------------");
                sortedScores.append("\n");
                //sortedScores.append(score[0]).append(" ").append(score[1]).append(" ").append(score[2]).append(" ").append(score[3]).append("\n");
            }

            reader.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sortedScores.toString();
    }
    public static String readLine(Context context, String filePath, int lineNumber) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(context.getFileStreamPath(filePath)));
            String line;
            int currentLine = 1;
            while ((line = reader.readLine()) != null) {
                if (currentLine == lineNumber) {
                    return line;
                }
                currentLine++;
            }
            // 지정된 줄 번호에 해당하는 줄이 없을 때
            return "Line " + lineNumber + " not found in the file.";
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while reading the file.";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static int countLines(Context context, String filePath) {
        int lineCount = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(context.getFileStreamPath(filePath)));
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lineCount;
    }
    //텍스트 파일의 모든 내용을 삭제하는 메소드
    public static void deleteFileContent(Context context, String fileName) {
        File file = new File(context.getFilesDir(), fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("File content deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while deleting file content.");
        }
    }
}
