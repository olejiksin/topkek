package s.e.search;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoSTask2 {

    public static void rek(int x, int y, int step, int[][] matrix) {

        int dx[] = {-1, 1, -2, -2, 2, 2, 1, -1};
        int dy[] = {2, 2, 1, -1, 1, -1, -2, -2};
        int xx[] = {-1, -1, -1, -1, -1, -1, -1, -1};
        int yy[] = {-1, -1, -1, -1, -1, -1, -1, -1};
        matrix[x][y] = step;
        for (int i = 0; i < 8; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if ((x1 >= 0) && (y1 >= 0) && (x1 < 10) && (y1 < 14) && (matrix[x1][y1] == -1)) {
                matrix[x1][y1] = step + 1;
                xx[i] = x1;
                yy[i] = y1;
            }
        }
        for (int i = 0; i < 8; i++) {
            if (xx[i] != -1) {
                rek(xx[i], yy[i], step + 1, matrix);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[10][14];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                matrix[i][j] = -1;
            }
        }
//        matrix[2][0] = 0;
        rek(0, 0, 0, matrix);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                if (matrix[i][j] <= 9) System.out.print(" 0" + matrix[i][j] + " ");
                else {
                    System.out.print(" " + matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
//        FileReader fileReader;
//        File file = new File("tokens.txt");
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        File file1 = new File("lemmas.txt");
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            FileWriter writer = new FileWriter("tokens.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < 100; i++) {
//            fileReader = new FileReader("выкачка/выкачка" + i);
//        }
    }
}
