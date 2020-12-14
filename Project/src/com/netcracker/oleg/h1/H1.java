package com.netcracker.oleg.h1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H1 {
    private static final String[] nums = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        Path testFilePath = Paths.get("Resources/h1/Text.txt"); //путь до файла
        String text = Files.readString(testFilePath, StandardCharsets.UTF_8); //чтение одной строкой исходного текста
        StringBuilder result = new StringBuilder();
        int longestWord = 0;
        int words = 0;
        int numbers = 0;
        int punct = 0;
        int pals = 0;
        int upp = 0;
        int low = 0;
        int upMoreLow = 0;

        //Задание 1
        doFirstEx(text, longestWord, words, numbers, punct, pals, result, upp, low, upMoreLow); //все подсчёты в тексте

        //Задание 2
        text = changeAlpToZero(text);
        text = changeNumberToWord(text);
        text = changeConsonant2xToUpperCons(text);
        text = removeAllVowels2xAndMore(text);

        //Запись в файл
        PrintWriter pw = new PrintWriter(new File("Resources/h1/Result.txt"));
        pw.print("");
        pw.println(text); //обработанный текс
        pw.print(result); //итоговые начения подсчёта
        pw.close();
    }

    //    -----------------------------------------------------
//static methods...
    private static void doFirstEx(String text, int longestWord, int words,
                                  int numbers, int punct, int pals, StringBuilder result,
                                  int up, int low, int upMoreLow) {
        Pattern p = Pattern.compile("\\p{Punct}");
        Pattern w = Pattern.compile("[A-Za-z]+");
        Pattern n = Pattern.compile("-?\\d+");

        String[] strings = text.split("\\s+"); // массив слов, цыфр, пунктуации

        for (String s : strings) {
            Matcher m = n.matcher(s);
            if (m.find()) { //если число меньше 100
                try{
                    if(Integer.parseInt(m.group()) < 100) {
                        numbers += 1;
                    }
                } catch (IllegalFormatException ignored) {
                }
            }
            if (p.matcher(s).find()) { // если знак препинания
                punct++;
            } else if (w.matcher(s).find()) { //если слово
                words++;
                int Z = countZ(s); up += Z;
                int P = countP(s); low += P;
                upMoreLow =+ (int)(Z > P ? 1 : 0);
                pals = countPal(s, pals);
                longestWord = countLong(s, longestWord);
            }
        }
        result.append("Amount of words: ").append(words).append("\n");
        result.append("Amount of punct: ").append(punct).append("\n");
        result.append("Amount of numm < 100: ").append(numbers).append("\n");
        result.append("Amount of letters in the longes word:").append(longestWord).append("\n");
        result.append("Amount of palindromes:").append(pals).append("\n");
        result.append("Amount of Upper: ").append(up).append("\n");
        result.append("Amount of Lower: ").append(low).append("\n");
        result.append("Upper more then lower:").append(upMoreLow).append("\n");
    }

//    -------------------------------------------------------

    private static int countLong(String s, int longestWord) {
        return Math.max(s.length(), longestWord);
    }

    private static int countZ(String s) {
        Matcher matcherZ = Pattern.compile("[A-Z]").matcher(s);
        int z = 0;
        while (matcherZ.find()) {
            z += matcherZ.end() - matcherZ.start();
        }
        return z;
    }

    private static int countP(String s) {
        Matcher matcherP = Pattern.compile("[a-z]").matcher(s);
        int p = 0;
        while (matcherP.find()) {
            p += matcherP.end() - matcherP.start();
        }
        return p;
    }

    private static int countPal(String s, int pals) {
        if(s.length() > 1) {
            if(s.replaceAll("\\W","").equalsIgnoreCase(new StringBuilder(s.replaceAll("\\W","")).reverse().toString())) {
                return pals + 1;
            }
        }
        return pals;
    }

//    ------------------------------------------------------

    private static String changeAlpToZero(String s) {
        return s.replace("O", "0").replace("o", "0");
    }

    private static String changeNumberToWord(String s) {
        for(int i = 1; i < 10; i++) {
            s = s.replace(String.valueOf(i), nums[i - 1]);
        }
        return s;
    }

    private static String doChangeOrRemove(String s, String reg, String mod) {
        StringBuilder sb = new StringBuilder(s);
        Matcher matcher = Pattern.compile(reg).matcher(s);
        while (matcher.find()) {
            if(mod.equals("change")) {
                sb.replace(matcher.start(), matcher.end(), matcher.group().toUpperCase());
            } else {
                sb.replace(matcher.start(), matcher.end(), matcher.group().replaceAll("(?i:[aeiouy])", " "));
            }
            s = sb.toString().replace("  ", "");
        }
        return s;
    }

    private static String changeConsonant2xToUpperCons(String s) {
        return doChangeOrRemove(s, "(?i:[wrtpsdfghkvlzxcbnm]+){2,}", "change");
    }

    private static String removeAllVowels2xAndMore(String s) {
        return doChangeOrRemove(s, "(?i:[aeiouy]){2,}", "delete"); //все глассные
    }
}