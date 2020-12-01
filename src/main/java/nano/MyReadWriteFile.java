package nano;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyReadWriteFile {

    private StringBuilder text;

    public MyReadWriteFile(String pathFromContentRoot) {
        try {
            readFile(pathFromContentRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder getText() {
        return text;
    }

    public void readFile(String nameFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
        text = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            text.append(line).append("\n");
        }
    }
}
