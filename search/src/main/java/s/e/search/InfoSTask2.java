package s.e.search;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.ru.RussianAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InfoSTask2 {

    public static void main(String[] args) throws IOException {
        File file = new File("tokensAndLemmas.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file1 = new File("lemmas.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter writer = null;
        FileWriter writer1 = null;
        try {
            writer = new FileWriter(file);
            writer1 = new FileWriter(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, HashSet<String>> mapSet = new HashMap<>();

        try {
            for (int i = 0; i < 100; i++) {
                Analyzer analyzer = null;
                String[] wordsFromFile = Files.lines(Paths.get("выкачка/выкачка" + i + ".txt")).findFirst().get().split(" ");
                if (wordsFromFile[0].toLowerCase().charAt(0) >= 1072 || wordsFromFile[0].toLowerCase().charAt(0) <= 1103
                        || wordsFromFile[0].toLowerCase().charAt(0) == 'ё') {
                    analyzer = new RussianAnalyzer();
                } else {
                    analyzer = new EnglishAnalyzer();
                }
                for (String s : wordsFromFile) {
                    String word = s.toLowerCase();
                    TokenStream stream = analyzer.tokenStream("field", word);
                    stream.reset();
                        String lemma = stream.getAttribute(CharTermAttribute.class).toString();
                            if (mapSet.get(lemma) == null) {
                                HashSet<String> set = new HashSet<>();
                                set.add(word);
                                mapSet.put(lemma, set);
                            } else {
                                HashSet<String> set;
                                set = mapSet.get(lemma);
                                set.add(word);
                                mapSet.put(lemma, set);
                            }
                    stream.end();
                    stream.close();
                }
            }
            for (String key : mapSet.keySet()) {
                if (key.length() > 2) {
                    StringBuilder allTokens = new StringBuilder(key + "");
                    for (String token : mapSet.get(key)) {
                        allTokens.append(" ").append(token);
                    }
                    writer.write(allTokens + "\n");
                    writer.flush();
                    writer1.write(key + "\n");
                    writer1.flush();
                }
            }
            writer.close();
            writer1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
