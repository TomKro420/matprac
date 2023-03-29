package com.example.mp_tk;

import java.util.Scanner;

public class PlayfairCipherEncipher {

    static char [] encrypt(String pt, String key) {
        pt = pt.toUpperCase();
        key = key.toUpperCase();
        char[] text_arr = pt.toCharArray();
        char[] key_arr = key.toCharArray();
        char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[][] table = new char[5][5];
    char[] encpt_arr = new char[100];
        int encpt_arr_ctr = 0;
        int ctr = -1;
        for (int i = 0; i < key_arr.length; i++)
            for (int j = 0; j < 25; j++)
                if (key_arr[i] == alpha[j]) {
                    ctr++;
                    int round = ctr / 5;
                    table[round][ctr % 5] = alpha[j];
                    alpha[j] = '0';
                    break;
                }
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != '0') {
                ctr++;
                int round = ctr / 5;
                table[round][ctr % 5] = alpha[i];
            }
        }
        char[] any = new char[100];
        int c = 0;
        for (int i = 0; i < text_arr.length; i++) {
            if (i == 0 && text_arr[i] != text_arr[i + 1] && i + 1 < text_arr.length) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i == 1 && text_arr[i] != text_arr[i + 1] && i + 1 < text_arr.length) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i == text_arr.length - 2 && i % 2 == 0 && text_arr[i] != text_arr[i - 1] && text_arr[i] != text_arr[i + 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i == text_arr.length - 2 && i % 2 == 0 && text_arr[i] != text_arr[i - 1] && text_arr[i] == text_arr[i + 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i == text_arr.length - 2 && i % 2 == 0 && text_arr[i] == text_arr[i - 1] && text_arr[i] != text_arr[i + 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i == text_arr.length - 2 && i % 2 == 0 && text_arr[i] == text_arr[i - 1] && text_arr[i] == text_arr[i + 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i == text_arr.length - 2 && i % 2 != 0 && text_arr[i] != text_arr[i - 1] && text_arr[i] != text_arr[i + 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i == text_arr.length - 2 && i % 2 != 0 && text_arr[i] != text_arr[i - 1] && text_arr[i] == text_arr[i + 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i == text_arr.length - 2 && i % 2 != 0 && text_arr[i] == text_arr[i - 1] && text_arr[i] != text_arr[i + 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i == text_arr.length - 2 && i % 2 != 0 && text_arr[i] == text_arr[i - 1] && text_arr[i] == text_arr[i + 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i == text_arr.length - 1 && i % 2 == 0 && text_arr[i] != text_arr[i - 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i == text_arr.length - 1 && i % 2 == 0 && text_arr[i] == text_arr[i - 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i == text_arr.length - 1 && i % 2 != 0 && text_arr[i] != text_arr[i - 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i == text_arr.length - 1 && i % 2 != 0 && text_arr[i] == text_arr[i - 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i % 2 == 0 && i > 0 && text_arr[i] != text_arr[i - 1] && text_arr[i] == text_arr[i + 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i % 2 == 0 &&  i > 0 && text_arr[i] != text_arr[i - 1] && text_arr[i] != text_arr[i + 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i % 2 == 0 &&  i > 0 && text_arr[i] == text_arr[i - 1] && text_arr[i] != text_arr[i + 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i % 2 == 0 &&  i > 0 && text_arr[i] == text_arr[i - 1] && text_arr[i] == text_arr[i + 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i % 2 != 0 && text_arr[i] != text_arr[i - 1] && text_arr[i] == text_arr[i + 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
            if (i % 2 != 0 && text_arr[i] != text_arr[i - 1] && text_arr[i] != text_arr[i + 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i % 2 != 0 && text_arr[i] == text_arr[i - 1] && text_arr[i] != text_arr[i + 1]) {
                any[c++] = text_arr[i];
                continue;
            }
            if (i % 2 != 0 && text_arr[i] == text_arr[i - 1] && text_arr[i] == text_arr[i + 1]) {
                any[c++] = text_arr[i];
                any[c++] = 'X';
                continue;
            }
        }
        if (c % 2 != 0) any[c++] = 'X';
        System.out.print("\n text preveden aby se dal zasifrovat: ");
        for (int i = 0; i < c; i++) System.out.print(any[i]);
        System.out.println();
        for (int i = 0; i < c; i = i + 2) {
            if (any[i] == 'J') any[i] = 'I';
            if (any[i + 1] == 'J') any[i + 1] = 'I';
            int row1 = 0, row2 = 0, col1 = 0, col2 = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (any[i] == table[j][k]) {
                        row1 = j;
                        col1 = k;
                        break;
                    }
                }
            }
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (any[i + 1] == table[j][k]) {
                        row2 = j;
                        col2 = k;
                        break;
                    }
                }
            }
            if (row1 == row2) {
                col1 = (col1 + 1) % 5;
                col2 = (col2 + 1) % 5;
                encpt_arr[encpt_arr_ctr++] = table[row1][col1];
                encpt_arr[encpt_arr_ctr++] = table[row2][col2];
            } else if (col1 == col2) {
                row1 = (row1 + 1) % 5;
                row2 = (row2 + 1) % 5;
                encpt_arr[encpt_arr_ctr++] = table[row1][col1];
                encpt_arr[encpt_arr_ctr++] = table[row2][col2];
            } else if (row1 != row2 && col1 != col2) {
                int row = 0, col = 0;
                row = row1;
                col = col2;
                encpt_arr[encpt_arr_ctr++] = table[row][col];
                row = row2;
                col = col1;
                encpt_arr[encpt_arr_ctr++] = table[row][col];
            } else {
            }
        }
        System.out.println("\n tabulka: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) System.out.print(table[i][j] + " ");
            System.out.print("\n");
        }
        System.out.print("\n zasifrovany text: ");
        for (int i = 0; i < encpt_arr_ctr; i++) System.out.print(encpt_arr[i]);
    return encpt_arr;
    }

    //main je jen pro testovaní
    public static void main(String[] args) {
        String pt, key;
        System.out.print("zadej nejakou vetu: ");
        Scanner scanner = new Scanner(System.in);
        pt = scanner.nextLine();
        System.out.print("zadej heslo: ");
        key = scanner.nextLine();
        scanner.close();
        encrypt(pt, key);
    }
}
//zde