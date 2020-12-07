package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.List;

public class Count  {


    private static List<Character> chars = new ArrayList<>();

    public List<Character> getOneSimbol(File filename) {
        chars.clear();
        BufferedReader reader = null;
        try {

            FileReader fileReader = new FileReader(filename);
            reader = new BufferedReader(fileReader);

            int c;
            while ((c = reader.read()) != -1) {
                chars.add((char) c);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return chars;
    }


    public void getCountSigns(File filename) {
        List<Character> array = getOneSimbol(filename);
        Object[] arra = array.toArray();
        int countSigns = 0;

        for (int i = 0; i < arra.length; i++) {
            if (((char) arra[i] == ',')
                    | ((char) arra[i] == '.')
                    | ((char) arra[i] == '!')
                    | ((char) arra[i] == '?')
                    | ((char) arra[i] == ':')
                    | ((char) arra[i] == ';')) {
                countSigns++;
            }


        }
        System.out.println("Кол-во знаков:  " + countSigns);

    }

    public void getLowercaseUppercaseLetters(File s) {
        List<Character> array1 = getOneSimbol(s);
        Object[] arraaa = array1.toArray();
        int countLowLetters = 0;
        int countUpLetters = 0;

        for (int i = 0; i < arraaa.length; i++) {


            if (((char) arraaa[i] == 'A') | ((char) arraaa[i] == 'a') |
                    ((char) arraaa[i] == 'B') | ((char) arraaa[i] == 'b') |
                    ((char) arraaa[i] == 'C') | ((char) arraaa[i] == 'c') |
                    ((char) arraaa[i] == 'D') | ((char) arraaa[i] == 'd') |
                    ((char) arraaa[i] == 'E') | ((char) arraaa[i] == 'e') |
                    ((char) arraaa[i] == 'F') | ((char) arraaa[i] == 'f') |
                    ((char) arraaa[i] == 'G') | ((char) arraaa[i] == 'g') |
                    ((char) arraaa[i] == 'H') | ((char) arraaa[i] == 'h') |
                    ((char) arraaa[i] == 'I') | ((char) arraaa[i] == 'i') |
                    ((char) arraaa[i] == 'J') | ((char) arraaa[i] == 'j') |
                    ((char) arraaa[i] == 'K') | ((char) arraaa[i] == 'k') |
                    ((char) arraaa[i] == 'L') | ((char) arraaa[i] == 'l') |
                    ((char) arraaa[i] == 'M') | ((char) arraaa[i] == 'm') |
                    ((char) arraaa[i] == 'N') | ((char) arraaa[i] == 'n') |
                    ((char) arraaa[i] == 'O') | ((char) arraaa[i] == 'o') |
                    ((char) arraaa[i] == 'P') | ((char) arraaa[i] == 'p') |
                    ((char) arraaa[i] == 'Q') | ((char) arraaa[i] == 'q') |
                    ((char) arraaa[i] == 'R') | ((char) arraaa[i] == 'r') |
                    ((char) arraaa[i] == 'S') | ((char) arraaa[i] == 's') |
                    ((char) arraaa[i] == 'T') | ((char) arraaa[i] == 't') |
                    ((char) arraaa[i] == 'U') | ((char) arraaa[i] == 'u') |
                    ((char) arraaa[i] == 'V') | ((char) arraaa[i] == 'v') |
                    ((char) arraaa[i] == 'W') | ((char) arraaa[i] == 'w') |
                    ((char) arraaa[i] == 'X') | ((char) arraaa[i] == 'x') |
                    ((char) arraaa[i] == 'Y') | ((char) arraaa[i] == 'y') |
                    ((char) arraaa[i] == 'Z') | ((char) arraaa[i] == 'z')
            ) {
                if (Character.isUpperCase((char) arraaa[i])) {
                    countUpLetters++;
                }
                if (Character.isLowerCase((char) arraaa[i])) {
                    countLowLetters++;
                }
            }
        }
        System.out.println("Кол-во прописных букв: " + countLowLetters + " \nКол-во заглавных букв:  " + countUpLetters);
    }

    public void printOo0(File filename) {
        List<Character> array1 = getOneSimbol(filename);
        Object[] arraaa = array1.toArray();

        for (int i = 0; i < arraaa.length; i++) {


            if (((char) arraaa[i] == 'O') | ((char) arraaa[i] == 'o')) {
                arraaa[i] = 0;

            }
        }
//        for (int i = 0; i < arraaa.length; i++) {
//            System.out.print(arraaa[i]);
//        }
    }

    public void printReplacement(File filename) {
        List<Character> array1 = getOneSimbol(filename);
        Object[] arraaa = array1.toArray();

        for (int i = 0; i < arraaa.length; i++) {

            switch ((char) arraaa[i]) {
                case '1':
                    arraaa[i] = "one";
                    break;
                case '2':
                    arraaa[i] = "two";
                    break;
                case '3':
                    arraaa[i] = "three";
                    break;
                case '4':
                    arraaa[i] = "four";
                    break;
                case '5':
                    arraaa[i] = "five";
                    break;
                case '6':
                    arraaa[i] = "six";
                    break;
                case '7':
                    arraaa[i] = "seven";
                    break;
                case '8':
                    arraaa[i] = "eight";
                    break;
                case '9':
                    arraaa[i] = "nine";
                    break;

            }

        }
//        for (int i = 0; i < arraaa.length; i++) {
//            System.out.print(arraaa[i]);
//        }
    }


}


