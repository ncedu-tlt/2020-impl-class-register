package nano;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        MyFileReader myFileReader = new MyFileReader();
        try {
            myFileReader.bufferedFile("src/main/resources/text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Phrase: \"" + myFileReader.getPhrase() + "\"");

        System.out.println("Words: " + myFileReader.getCountWords());

        System.out.println("Punctuation marks: " + myFileReader.getCountPunctuationMark());
    }
}
