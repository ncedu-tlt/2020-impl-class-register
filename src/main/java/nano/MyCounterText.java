package nano;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCounterText {

    private final static Pattern WORD = Pattern.compile("[a-zA-Z]+-?[a-zA-Z]*");

    private final StringBuilder text;

    public MyCounterText(StringBuilder text) {
        this.text = text;
    }

    public int getCountWords() {
        int count = 0;

        Matcher matcher = WORD.matcher(text);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getCountPunctuationMark() {
        int count = 0;

        Pattern pattern = Pattern.compile("[,.!?():;-]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getCountLowerCase() {
        int count = 0;

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getCountUpperCase() {
        int count = 0;

        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getCountLongestWord() {
        int count = 0;

        Matcher matcher = WORD.matcher(text);

        char[] chars;
        while (matcher.find()) {
            chars = text.substring(matcher.start(), matcher.end()).toCharArray();
            if (count < chars.length) {
                count = chars.length;
            }
        }

        return count;
    }

    public int getCountNumbersLessHundred() {
        int count = 0;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        int num;
        while (matcher.find()) {
            num = Integer.parseInt(text.substring(matcher.start(), matcher.end()));
            if (num < 100) {
                count++;
            }
        }

        return count;
    }

    public int getCountWordUpperCaseMoreLowerCase() {
        int count = 0;

        Matcher matcher = WORD.matcher(text);

        int countUpper = 0;
        int countLower = 0;
        char[] chars;
        while (matcher.find()) {
            chars = text.substring(matcher.start(), matcher.end()).toCharArray();

            for (Character character : chars) {
                if (character.toString().matches("[A-Z]")) {
                    countUpper++;
                }
                if (character.toString().matches("[a-z]")) {
                    countLower++;
                }
            }

            if (countUpper > countLower) {
                count++;
            }
        }

        return count;
    }

    public int getCountPalindromes() {
        int count = 0;

        Matcher matcher = WORD.matcher(text);

        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher1;

        String word;
        String reversed;
        while (matcher.find()) {
            word = text.substring(matcher.start(), matcher.end()).toLowerCase();
            reversed = reverse(word);
            matcher1 = pattern.matcher(word);
            if (!matcher1.matches()) {
                if (word.equals(reversed)) {
                    count++;
                }
            }
        }

        return count;
    }

    private String reverse(String word) {
        StringBuilder reversed = new StringBuilder();
        for (int i = word.length(); i > 0 ; i--) {
            reversed.append(word.charAt(i - 1));
        }
        return reversed.toString();
    }
}
