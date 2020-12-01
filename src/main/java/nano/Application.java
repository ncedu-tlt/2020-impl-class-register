package nano;

public class Application {

    public static void main(String[] args) {
        ReadCountWriteFile reader = new ReadCountWriteFile("src/main/resources/text.txt");

        System.out.println("Phrase:\n" + reader.getPhrase());
        System.out.println("Words: " + reader.getCountWords());
        System.out.println("Punctuation marks: " + reader.getCountPunctuationMark());
        System.out.println("Lower case: " + reader.getCountLowerCase());
        System.out.println("Upper case: " + reader.getCountUpperCase());
        System.out.println("The longest word: " + reader.getLongestWord() + " characters");

    }
}
