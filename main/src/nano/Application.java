package nano;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        MyFileReader myFileReader = new MyFileReader();
        try {
            myFileReader.bufferedFile("main/resources/text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(myFileReader.getStringBuilder());

        System.out.println("Words = " + myFileReader.countWords());
    }
}
