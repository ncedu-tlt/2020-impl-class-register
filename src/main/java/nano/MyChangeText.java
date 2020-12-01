package nano;

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
}
