package com.example.chet;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        int[] arr1 = new int[sc.nextInt()];
        String first = sc1.nextLine();
        int[] arr2 = new int[sc.nextInt()];
        String second = sc1.nextLine();

        if ((arr1.length >= 1 && arr1.length <= 1000000) && (arr2.length >= 1 && arr2.length <= 1000000)) {
            String all1[] = first.split(" ");
            String all2[] = second.split(" ");
            boolean firstTrue = true;
            boolean secondTrue = true;
            for (int i = 0; i < all1.length; i++) {
                arr1[i] = Integer.parseInt(all1[i]);
            }
            for (int i = 0; i < all2.length; i++) {
                arr2[i] = Integer.parseInt(all2[i]);
            }
            if (arr1.length>=2) {
                if (arr1[arr1.length - 2] > arr1[arr1.length - 1]) {
                    firstTrue = false;
                }
            }
            if (arr1.length > 2) {
                for (int i = 0; i < arr1.length - 1; i++) {
                    if (arr1[i] > arr1[i + 1]) {
                        firstTrue = false;
                    }
                }
            }
            if (arr2.length >= 2) {
                if (arr2[arr2.length - 2] > arr2[arr2.length - 1]) {
                    secondTrue = false;
                }
            }
            if (arr2.length > 2) {
                for (int i = 0; i < arr2.length - 1; i++) {
                    if (arr2[i] > arr2[i + 1]) {
                        secondTrue = false;
                    }
                }
            }
            if (secondTrue && firstTrue) {
                int res = Math.abs(arr1[0] - arr2[0]);
                int firstRes = arr1[0];
                int secondRes = arr2[0];

                for (int i = 0; i < arr1.length; i++) {
                    for (int j = 0; j < arr2.length; j++) {
                        if (Math.abs(arr1[i] - arr2[j]) < res) {
                            res = Math.abs(arr1[i] - arr2[j]);
                            firstRes = arr1[i];
                            secondRes = arr2[j];
                        }
                    }
                }
                System.out.println(firstRes + " " + secondRes);
            }
        }
    }
}
