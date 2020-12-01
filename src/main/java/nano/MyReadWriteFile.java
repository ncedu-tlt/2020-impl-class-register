package nano;

import java.io.*;

public class MyReadWriteFile {

    private StringBuilder text;

    public MyReadWriteFile(String pathname) {
        try {
            readFile(pathname);
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

    public void writeFile(String data) {
        File file = new File("src/main/resources/new_text.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
            System.out.println("\n" + file.getName() + " write success and save.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
