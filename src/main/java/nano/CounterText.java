package nano;

import java.util.regex.Matcher;

public class CounterText {

    private Matcher matcher;
    private int count;

    public CounterText(StringBuilder text) {
        splitText(text.toString());
    }

    public int getCountWords() {
        return Lists.WORD_LIST.size();
    }

    public int getCountPunctuationMark() {
        return Lists.PUNCTUATION_MARK_LIST.size();
    }

    public int getCountLowerCase() {
        count = 0;

        matcher = Patterns.LOWER_CASE.matcher(Lists.WORD_LIST.toString());

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getCountUpperCase() {
        count = 0;

        matcher = Patterns.UPPER_CASE.matcher(Lists.WORD_LIST.toString());

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getCountLongestWord() {
        count = 0;

        char[] chars;

        for (String word : Lists.WORD_LIST) {
            chars = word.toCharArray();
            if (count < chars.length) {
                count = chars.length;
            }
        }

        return count;
    }

    public int getCountNumbersLessHundred() {
        count = 0;

        for (String number : Lists.NUMBER_LIST) {
            if (number.startsWith("-")) {
                count++;
            } else if (Float.parseFloat(number) < 100) {
                count++;
            }
        }

        return count;
    }

    public int getCountWordUpperCaseMoreLowerCase() {
        count = 0;

        int countUpper = 0;
        int countLower = 0;
        char[] chars;

        for (String word : Lists.WORD_LIST) {
            chars = word.toCharArray();

            for (Character character : chars) {
                if (character.toString().matches(String.valueOf(Patterns.UPPER_CASE))) {
                    countUpper++;
                }
                if (character.toString().matches(String.valueOf(Patterns.LOWER_CASE))) {
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
        count = 0;

        StringBuilder wordBuilder;
        for (String word : Lists.WORD_LIST) {
            if (word.toCharArray().length > 1) {
                wordBuilder = new StringBuilder();
                wordBuilder.append(word);

                if (word.equalsIgnoreCase(wordBuilder.reverse().toString())) {
                    count++;
                }
            }
        }

        return count;
    }

    private void splitText(String text) {
        matcher = Patterns.WORD.matcher(text);
        while (matcher.find()) {
            Lists.WORD_LIST.add(getTextSubstring(text));
        }

        matcher = Patterns.PUNCTUATION_MARK.matcher(text);
        while (matcher.find()) {
            Lists.PUNCTUATION_MARK_LIST.add(getTextSubstring(text));
        }

        matcher = Patterns.REAL_NUMBER.matcher(text);
        while (matcher.find()) {
            Lists.NUMBER_LIST.add(getTextSubstring(text));
        }
    }

    private String getTextSubstring(String text) {
        return text.substring(matcher.start(), matcher.end());
    }
}
