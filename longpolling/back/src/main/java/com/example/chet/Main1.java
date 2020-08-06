package com.example.chet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int res = 0;
        int a = 0;
        while (sc.hasNextInt() && list.size() < 1000) {
            a = sc.nextInt();
            if (a == 0) {
                break;
            }
            if (a > 0 && a < 10000) {
                list.add(a);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                k++;
                res = k;
            } else if (arr[i] == arr[i + 1]) {
                i++;
            } else {
                k = 0;
                i++;
            }
        }

        k = 0;
        int res1 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                k++;
                res1 = k;
            } else if (arr[i] == arr[i + 1]) {
                i++;
            } else {
                k = 0;
                i++;
            }
        }
        if (res1 > res) {
            System.out.print(res1-1);
        } else if (res > res1) {
            System.out.print(res-1);
        }
    }
}
