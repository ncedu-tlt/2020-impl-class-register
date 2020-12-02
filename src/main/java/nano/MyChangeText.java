package nano;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyChangeText {

    private final StringBuilder text;

    public MyChangeText(StringBuilder text) {
        this.text = text;
    }

    public StringBuilder getText() {
        return text;
    }

    public void replacingOWithZero() {
        Pattern pattern = Pattern.compile("[oO]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            text.replace(matcher.start(), matcher.end(), "0");
        }
    }

    public void replacingNumbersWithWords() {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(text);

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
            matcher = pattern.matcher(text);
        }
    }
}
