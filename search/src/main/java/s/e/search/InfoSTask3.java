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

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

public class InfoSTask3 {


    // лемматизация слов, сбор индексов документов
    private static void createIndexes() throws IOException {
        Map<String, HashSet<Integer>> mapSet = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Analyzer analyzer = null;
            String[] wordsFromFile = Files.lines(Paths.get("выкачка/выкачка" + i + ".txt")).findFirst().get().split(" ");
            if (wordsFromFile[0].toLowerCase().charAt(0) >= 1072 && wordsFromFile[0].toLowerCase().charAt(0) <= 1103
                    || wordsFromFile[0].toLowerCase().charAt(0) == 'ё') {
                analyzer = new RussianAnalyzer();
            } else {
                analyzer = new EnglishAnalyzer();
            }
            for (String s : wordsFromFile) {
                String word = s.toLowerCase();
                TokenStream stream = analyzer.tokenStream("field", word);
                stream.reset();
                while (stream.incrementToken()) {
                    String lemma = stream.getAttribute(CharTermAttribute.class).toString();
                    if (mapSet.get(lemma) == null) {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(i);
                        mapSet.put(lemma, set);
                    } else {
                        HashSet<Integer> set;
                        set = mapSet.get(lemma);
                        set.add(i);
                        mapSet.put(lemma, set);
                    }
                }
                stream.end();
                stream.close();
            }
        }
        File file = new File("indexes.txt");
        FileWriter writer = new FileWriter(file);

        for (String key : mapSet.keySet()) {
            StringBuilder allTokens = new StringBuilder(key + "");
            for (Integer doc : mapSet.get(key)) {
                allTokens.append(" ").append(doc);
            }
            writer.write(allTokens + "\n");
            writer.flush();
        }
    }

    private static List<Integer> booleanSearch(String string) {
        List<Integer> list = new ArrayList<>();
        String stringArr[] = string.toLowerCase().split(" ");
        Analyzer analyzer = null;
        if (string.toLowerCase().charAt(0) >= 1072 && string.toLowerCase().charAt(0) <= 1103 || string.toLowerCase().charAt(0) == 'ё') {
            analyzer = new RussianAnalyzer();
        } else analyzer = new EnglishAnalyzer();
        try {
            File file = new File("indexes.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            StringBuilder result = new StringBuilder();
            while (line != null) {
                result.append("\n" + line);
                line = br.readLine();
            }
            List<List<Integer>> indexList = new ArrayList<>();
            for (int k = 0; k < stringArr.length; k++) {
                List<Integer> chList = null;
                TokenStream stream = analyzer.tokenStream("field", stringArr[k]);
                stream.reset();
                String lem="";
                while(stream.incrementToken()){
                    lem=stream.getAttribute(CharTermAttribute.class).toString();
                }
                stream.end();
                stream.close();
                String[] splited = result.toString().split("\n");
                for (int i = 0; i < splited.length; i++) {
                    if (splited[i].split(" ")[0].equals(lem)) {
                        chList = new ArrayList<>();
                        String[] ar=splited[i].split(" ");
                        for (int m = 1; m < ar.length; m++) {
                            chList.add(Integer.parseInt(ar[m]));
                        }
                    }
                }
                if (chList != null) {
                    indexList.add(chList);
                }
            }
            list = indexList.get(0);
            if (indexList.size() > 1) {
                for (int i = 1; i < indexList.size(); i++) {
                    list.retainAll(indexList.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            createIndexes();

            //вводим строку с запросом в аттрибут метода, получаем индексы документов
            //cancel 40 73 58
            //ряд 0 16 80 84 23 41 73 90 27 45 61
            List<Integer> list = booleanSearch("cancel ряд");
            //должен вывести 73

            for (Integer k : list) {
                System.out.print(k + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
