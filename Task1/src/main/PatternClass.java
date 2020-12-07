package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternClass {


    private static List<Character> chars = new ArrayList<>();

    private final StringBuilder text;

    public PatternClass(StringBuilder text) {
        this.text = text;
    }

    public StringBuilder getText() {
        return text;
    }

    public void printOo0() {
        Pattern pattern = Pattern.compile("[oO]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            text.replace(matcher.start(), matcher.end(), "0");
        }
    }

    public void printReplacement() {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(text);

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("0", "zero");
        hashMap.put("1", "one");
        hashMap.put("2", "two");
        hashMap.put("3", "three");
        hashMap.put("4", "four");
        hashMap.put("5", "five");
        hashMap.put("6", "six");
        hashMap.put("7", "seven");
        hashMap.put("8", "eight");
        hashMap.put("9", "nine");

        String w;
        while (matcher.find()) {
            w = text.substring(matcher.start(), matcher.end());
            if (hashMap.containsKey(w)) {
                text.replace(matcher.start(), matcher.end(), hashMap.get(w));
            }
            matcher = pattern.matcher(text);
        }
    }

    public void replacingConsonantMoreOneWithUpperCase() {
        String consonantMoreOne = "[b-df-hj-np-tv-xzB-DF-HJ-NP-TV-XZ]{2,}";

        Pattern pattern = Pattern.compile(consonantMoreOne);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            text.replace(matcher.start(), matcher.end(),
                    text.substring(matcher.start(), matcher.end()).toUpperCase());
        }
    }

    public void deleteVowelMoreOne() {
        String vowelMoreOne = "[aeiouyAEIOUY]{2,}";

        Pattern pattern = Pattern.compile(vowelMoreOne);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            text.delete(matcher.start(), matcher.end());
            matcher = pattern.matcher(text);
        }
    }
}

