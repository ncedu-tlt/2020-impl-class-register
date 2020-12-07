package nano;

import java.io.*;

public class ReadWriteFile {

    public static StringBuilder readFile(String nameFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
        StringBuilder text = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            text.append(line).append("\n");
        }

        return text;
    }

    public static void writeFile(String data) {
        File file = new File("src/main/resources/new_text.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
            System.out.println("\n" + file.getName() + " write success and save in resources.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
