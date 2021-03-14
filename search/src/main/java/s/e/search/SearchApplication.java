package s.e.search;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class SearchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            FileWriter fileWriter;
            FileReader fileReader = new FileReader("sites.txt");
//            System.out.println((int)'я');
            BufferedReader bf = new BufferedReader(fileReader);
            String[] sites = new String[100];
            String line = bf.readLine();
            int i = 0;
            while (line != null) {
                sites[i] = line;
                i++;
                line = bf.readLine();
            }
            FileWriter fl = new FileWriter("index.txt");
            for (int k = 72; k < 74; k++) {
                System.out.println(sites[k]);
                Document doc = Jsoup.connect(sites[k]).get();
                String predResult = doc.body().text();
                File file = new File("выкачка/выкачка" + k + ".txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                String result = "" + doc.body().text().toCharArray()[0];
                for (int j = 1; j < predResult.toCharArray().length; j++) {
                    if (((int) predResult.toCharArray()[j] >= 1040 && (int) predResult.toCharArray()[j] <= 1071
                            && (int) predResult.toCharArray()[j - 1] >= 1072 && (int) predResult.toCharArray()[j - 1] <= 1103)
                            || ((int) predResult.toCharArray()[j] >= 65 && (int) predResult.toCharArray()[j] <= 90
                            && (int) predResult.toCharArray()[j - 1] >= 97 && (int) predResult.toCharArray()[j - 1] <= 122)
                    ) {
                        result += ' ';
                    }
                    if (
                            (int) predResult.toCharArray()[j] >= 65 && (int) predResult.toCharArray()[j] <= 90
                                    || (int) predResult.toCharArray()[j] >= 97 && (int) predResult.toCharArray()[j] <= 122
                                    || (int) predResult.toCharArray()[j] >= 1040 && (int) predResult.toCharArray()[j] <= 1071
                                    || (int) predResult.toCharArray()[j] >= 1072 && (int) predResult.toCharArray()[j] <= 1103
                                    || predResult.toCharArray()[j] == 'ё' || predResult.toCharArray()[j] == 'Ё') {
                        result += predResult.toCharArray()[j];
                    } else result += ' ';
                }
                fileWriter = new FileWriter(file);
                fileWriter.write(result);
                fileWriter.flush();
                fileWriter.close();
                fl.write(k + " " + sites[k] + "\n");
                fl.flush();
            }
            fl.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
