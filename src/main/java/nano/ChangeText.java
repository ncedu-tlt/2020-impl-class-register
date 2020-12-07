package nano;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class ChangeText {

    private Matcher matcher;

    public StringBuilder replacingOWithZero(StringBuilder text) {
        matcher = Patterns.LETTER_O.matcher(text);

        while (matcher.find()) {
            text.replace(matcher.start(), matcher.end(), "0");
        }

        return text;
    }

    public StringBuilder replacingNumbersWithWords(StringBuilder text) {
        matcher = Patterns.NUMBER.matcher(text);

        Map<String, String> mapNums = new HashMap<>();
        mapNums.put("0", "zero");
        mapNums.put("1", "one");
        mapNums.put("2", "two");
        mapNums.put("3", "three");
        mapNums.put("4", "four");
        mapNums.put("5", "five");
        mapNums.put("6", "six");
        mapNums.put("7", "seven");
        mapNums.put("8", "eight");
        mapNums.put("9", "nine");

        String key;
        while (matcher.find()) {
            key = text.substring(matcher.start(), matcher.end());
            if (mapNums.containsKey(key)) {
                text.replace(matcher.start(), matcher.end(), mapNums.get(key));
            }
            matcher = Patterns.NUMBER.matcher(text);
        }

        return text;
    }

    public StringBuilder replacingConsonantMoreOneWithUpperCase(StringBuilder text) {
        matcher = Patterns.CONSONANT_MORE_ONE.matcher(text);

        while (matcher.find()) {
            text.replace(matcher.start(), matcher.end(),
                    text.substring(matcher.start(), matcher.end()).toUpperCase());
        }

        return text;
    }

    public StringBuilder deleteVowelMoreOne(StringBuilder text) {
        matcher = Patterns.VOWEL_MORE_ONE.matcher(text);

        while (matcher.find()) {
            text.delete(matcher.start(), matcher.end());
            matcher = Patterns.VOWEL_MORE_ONE.matcher(text);
        }

        return text;
    }
}
