package nano;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFileReader {

    private final static Pattern WORD = Pattern.compile("[\\s(]\\w+");

    private StringBuilder phrase;

    public void bufferedFile(String nameFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
        phrase = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            phrase.append(line).append("\n");
        }
    }

    public StringBuilder getPhrase() {
        return phrase;
    }

    public int getCountWords() {
        int count = 0;

        Matcher matcher = WORD.matcher(phrase);

        while (matcher.find()) {
            count++;
        }

        if (count != 0) {
            count++;
        }

        return count;
    }

    public int getCountPunctuationMark() {
        int count = 0;

        Pattern pattern = Pattern.compile("[,.!?():;\\-]");
        Matcher matcher = pattern.matcher(phrase);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getCountLowerCase() {
        int count = 0;

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(phrase);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getCountUpperCase() {
        int count = 0;

        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(phrase);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int getLongestWord() {
        int count = 0;

        Pattern pattern = Pattern.compile("^\\w+");
        Matcher matcher = pattern.matcher(phrase);

        while (matcher.find()) {
            char[] chars = phrase.substring(matcher.start(), matcher.end()).toCharArray();
            count = chars.length;
        }

        matcher = WORD.matcher(phrase);

        while (matcher.find()) {
            char[] chars = phrase.substring(matcher.start(), matcher.end()).toCharArray();
            if (count < chars.length - 1) {
                count = chars.length - 1;
            }
        }

        return count;
    }
}
