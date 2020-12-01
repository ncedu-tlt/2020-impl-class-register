package nano;

public class Application {

    public static void main(String[] args) {
        MyReadWriteFile readWriteFile = new MyReadWriteFile("src/main/resources/text.txt");

        System.out.println("Text:\n" + readWriteFile.getText());

        MyCounterText counterText = new MyCounterText(readWriteFile.getText());

        System.out.println("Words: " + counterText.getCountWords());
        System.out.println("Punctuation marks: " + counterText.getCountPunctuationMark());
        System.out.println("Lower case: " + counterText.getCountLowerCase());
        System.out.println("Upper case: " + counterText.getCountUpperCase());
        System.out.println("The longest word: " + counterText.getCountLongestWord() + " characters");
        System.out.println("Numbers less 100: " + counterText.getCountNumbersLessHundred());
        System.out.println("Word when upper case more lower case: " + counterText.getCountWordUpperCaseMoreLowerCase());
        System.out.println("Palindromes: " + counterText.getCountPalindromes());
    }
}
