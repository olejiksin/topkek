package s.e.search;

import java.io.*;

public class InfoSTask2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader;
        File file = new File("words.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter writer = new FileWriter("words.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            fileReader = new FileReader("выкачка/выкачка" + i);
        }
    }
}
