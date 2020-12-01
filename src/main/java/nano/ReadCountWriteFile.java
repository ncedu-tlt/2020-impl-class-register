package nano;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadCountWriteFile {

    private final static Pattern WORD = Pattern.compile("[a-zA-Z]+-?[a-zA-z]*");

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

        while (matcher.find()) {
            char[] chars = text.substring(matcher.start(), matcher.end()).toCharArray();
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

        while (matcher.find()) {
            int num = Integer.parseInt(text.substring(matcher.start(), matcher.end()));
            if (num < 100) {
                count++;
            }
        }

        return count;
    }

    public int getCountWordUpperCaseMoreLowerCase() {
        int count = 0;

        Matcher matcher = WORD.matcher(text);

        while (matcher.find()) {
            int countUpper = 0;
            int countLower = 0;
            char[] characters;
            characters = text.substring(matcher.start(), matcher.end()).toCharArray();

            for (Character character : characters) {
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
}
