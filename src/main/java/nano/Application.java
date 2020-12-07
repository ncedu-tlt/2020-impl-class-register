package nano;

import java.io.IOException;

public class Application {

    private static StringBuilder text;

    public static void main(String[] args) {
        readFile();
        countText();
        changeTextAndWrite();
    }

    private static void readFile() {
        try {
            text = ReadWriteFile.readFile("src/main/resources/text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Text:\n" + text);
    }

    private static void countText() {
        assert text != null;
        CounterText counterText = new CounterText(text);

        System.out.println("Words: " + counterText.getCountWords());
        System.out.println("Punctuation marks: " + counterText.getCountPunctuationMark());
        System.out.println("Lower case: " + counterText.getCountLowerCase());
        System.out.println("Upper case: " + counterText.getCountUpperCase());
        System.out.println("The longest word: " + counterText.getCountLongestWord() + " characters");
        System.out.println("Numbers less 100: " + counterText.getCountNumbersLessHundred());
        System.out.println("Word when upper case more lower case: " + counterText.getCountWordUpperCaseMoreLowerCase());
        System.out.println("Palindromes: " + counterText.getCountPalindromes());
    }

    private static void changeTextAndWrite() {
        ChangeText changeText = new ChangeText();

        text = changeText.replacingOWithZero(text);
        text = changeText.replacingNumbersWithWords(text);
        text = changeText.replacingConsonantMoreOneWithUpperCase(text);
        text = changeText.deleteVowelMoreOne(text);

        ReadWriteFile.writeFile(text.toString());
    }
}
