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
            BufferedReader bf = new BufferedReader(fileReader);
            String[] sites = new String[100];
            String line = bf.readLine();
            int i = 0;
            while (line != null) {
                sites[i] = line;
                i++;
                line = bf.readLine();
            }
            FileWriter fl=new FileWriter("index.txt");
            for (int k = 0; k < 100; k++) {
                System.out.println(sites[k]);
                Document doc = Jsoup.connect(sites[k]).get();
                File file = new File("выкачка/выкачка" + k + ".txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileWriter = new FileWriter(file);
                fileWriter.write(doc.body().text());
                fileWriter.flush();
                fileWriter.close();
                fl.write(k + " " + sites[k]+"\n");
                fl.flush();
            }
            fl.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
