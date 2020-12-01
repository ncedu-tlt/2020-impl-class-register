package nano;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadCountWriteFile {

    private final static Pattern WORD = Pattern.compile("[\\s(]\\w+");

    private StringBuilder text;

    public ReadCountWriteFile(String nameFile) {
        try {
            readFile(nameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String nameFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
        text = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            text.append(line).append("\n");
        }
    }

    public StringBuilder getPhrase() {
        return text;
    }

    public int getCountWords() {
        int count = 0;

        Matcher matcher = WORD.matcher(text);

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

        Pattern pattern = Pattern.compile("^\\w+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            char[] chars = text.substring(matcher.start(), matcher.end()).toCharArray();
            count = chars.length;
        }

        matcher = WORD.matcher(text);

        while (matcher.find()) {
            char[] chars = text.substring(matcher.start(), matcher.end()).toCharArray();
            if (count < chars.length - 1) {
                count = chars.length - 1;
            }
        }

        return count;
    }

    public int getCountNumbersLessHundred() {
        int count = 0;

        Pattern pattern = Pattern.compile("\\d+\\d*");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int num = Integer.parseInt(text.substring(matcher.start(), matcher.end()));
            if (num < 100) {
                count++;
            }
        }

        return count;
    }
}
