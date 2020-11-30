package nano;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFileReader {

    private StringBuilder phrase;

    public void bufferedFile(String nameFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
        phrase = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            phrase.append(line).append(" ");
        }
    }

    public StringBuilder getPhrase() {
        return phrase;
    }

    public int getCountWords() {
        String[] countWords = phrase.toString().split(" ");
        return countWords.length;
    }

    public int getCountPunctuationMark() {
        Pattern pattern = Pattern.compile("[,.!?:;'\\-]");
        Matcher matcher = pattern.matcher(phrase);
        int countPunctuationMark = 0;
        while (matcher.find()) {
            countPunctuationMark++;
        }
        return countPunctuationMark;
    }
}
