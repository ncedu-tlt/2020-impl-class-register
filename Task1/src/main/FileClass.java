package main;

import java.io.*;

public class FileClass {



    private StringBuilder text;

    public FileClass(String pathname) {
        try {
            readFile(pathname);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder getText() {
        return text;
    }

    public void writeFile(String data) {
        File file = new File("Task1/src/main/File/text_new_edition.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
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
}
