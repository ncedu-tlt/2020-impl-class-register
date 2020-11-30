package nano;

import java.io.*;

public class MyFileReader {

    private BufferedReader bufferedReader;
    private StringBuilder stringBuilder;

    public void bufferedFile(String nameFile) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(new File(nameFile)));
        stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public int countWords() throws IOException {
        int countWords = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {

        }
        return countWords;
    }
}
