package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Word {

    private static List<String[]> arrayList = new ArrayList<>();

    public void getWordCount(File filename) throws FileNotFoundException {
        arrayList.clear();
        Scanner scanner = new Scanner(filename);
        int words = 0;


        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;
        }

        System.out.println("Кол-во слов: " + words);
        scanner.close();
    }

    public void getWordCountMax(File filename) throws FileNotFoundException {
        arrayList.clear();
        Scanner scanner = new Scanner(filename);

        while (scanner.hasNextLine()) {
            arrayList.add(scanner.nextLine().split(" "));
        }
        String[] w;
        int maxsize = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            w = arrayList.get(i);
            for (int j = 0; j < w.length; j++) {
                if (w[j].length() > maxsize) {
                    maxsize = w[j].length();
                }

            }

        }
        System.out.println("Максимальная длина слова в тексте : " + maxsize);
    }

    public void getNumber100(File filename) throws FileNotFoundException {
        arrayList.clear();
        Scanner scanner = new Scanner(filename);

        while (scanner.hasNextLine()) {
            arrayList.add(scanner.nextLine().split(" "));
        }
        String[] w;
        int maxsize = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            w = arrayList.get(i);
            for (int j = 0; j < w.length; j++) {
                if (isNumeric(w[j])) {
                    if (100 > Double.valueOf(w[j])) {
                        maxsize++;
                    }
                }

            }
        }
        System.out.println("Количество чисел <100 :" + maxsize);
    }


    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }


    public void getMaxUppercase(File filename) throws FileNotFoundException {
        arrayList.clear();
        Scanner scanner = new Scanner(filename);

        while (scanner.hasNextLine()) {
            arrayList.add(scanner.nextLine().split(" "));
        }
        String[] w;
        int maxsize = 0;
        int low = 0;
        int up = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            w = arrayList.get(i);
            for (int j = 0; j < w.length; j++) {
                String buf = w[j];
                for (int k = 0; k < buf.length(); k++) {
                    char buff = buf.charAt(k);
                    if (Character.isUpperCase(buff)) {
                        up++;
                    } else {
                        if (Character.isLowerCase(buff)) {
                            low++;
                        }
                        if (up > low) {
                            maxsize++;

                        }
                        up = 0;
                        low = 0;
                    }
                }

            }
        }
        System.out.println("Cлов, где больше заглавных букв чем строчных: " + maxsize);
    }

    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public void getCountPalindrome(File filename) throws FileNotFoundException {
        arrayList.clear();
        Scanner scanner = new Scanner(filename);

        while (scanner.hasNextLine()) {
            arrayList.add(scanner.nextLine().split(" "));
        }
        String[] w;
        int maxsize = 0;


        for (int i = 0; i < arrayList.size(); i++) {
            w = arrayList.get(i);
            for (int j = 0; j < w.length; j++) {
                if(isPalindrome(w[j])){
                    maxsize++;
                }
            }
        }
        System.out.println("Cлов палиндромов: " + maxsize);
    }




}


