package org.example.prefixSumCf3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bi.readLine().split("\\s");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);
        int n3 = Integer.parseInt(s[2]);
        int n4 = Integer.parseInt(s[3]);
        int n5 = Integer.parseInt(s[4]);
//        Scanner sc = new Scanner(System.in);
////        int m = sc.nextInt();
        long[][][][][] bArr = new long[n1] [ n2] [ n3] [ n4][n5];
        long[][][][][] prArr = new long[n1+1][n2+1][n3+1][n4+1][n5 + 1];
//        int j = 0;
        for (int a = 0; a < n1; a++) {
            for (int b = 0; b < n2; b++) {
                for (int c = 0; c < n3; c++) {
                    for (int d = 0; d < n4; d++) {
                            String[] ans = bi.readLine().split("\\s");
                        for (int e = 0; e < n5; e++) {


                            bArr[a][b][c][d][e] =Long.parseLong(ans[e]);
                            prArr[a][b][c][d][e] = 0;
                        }
                    }
                }
            }
        }
//        Arrays.fill(prArr,0);

        for (int a = 0; a < n1; a++) {
            for (int b = 0; b < n2; b++) {
                for (int c = 0; c < n3; c++) {
                    for (int d = 0; d < n4; d++) {
                        for (int e = 0; e < n5; e++) {
                            prArr[a + 1][b + 1][c + 1][d + 1][e + 1] =
                                    prArr[a + 1][b + 1][c + 1][d + 1][e] +
                                            prArr[a + 1][b + 1][c + 1][d][e + 1] +
                                            prArr[a + 1][b + 1][c][d + 1][e + 1] +
                                            prArr[a + 1][b][c + 1][d + 1][e + 1] +
                                            prArr[a][b + 1][c + 1][d + 1][e + 1] -
                                            prArr[a][b][c + 1][d + 1][e + 1] -
                                            prArr[a][b + 1][c][d + 1][e + 1] -
                                            prArr[a][b + 1][c + 1][d][e + 1] -
                                            prArr[a][b + 1][c + 1][d + 1][e] -
                                            prArr[a + 1][b][c][d + 1][e + 1] -
                                            prArr[a + 1][b][c + 1][d][e + 1] -
                                            prArr[a + 1][b][c + 1][d + 1][e] -
                                            prArr[a + 1][b + 1][c][d][e + 1] -
                                            prArr[a + 1][b + 1][c][d + 1][e] -
                                            prArr[a + 1][b + 1][c + 1][d][e] +
                                            prArr[a + 1][b + 1][c][d][e] +
                                            prArr[a + 1][b][c + 1][d][e] +
                                            prArr[a + 1][b][c][d + 1][e] +
                                            prArr[a + 1][b][c][d][e + 1] +
                                            prArr[a][b + 1][c + 1][d][e] +
                                            prArr[a][b + 1][c][d + 1][e] +
                                            prArr[a][b + 1][c][d][e + 1] +
                                            prArr[a][b][c + 1][d + 1][e] +
                                            prArr[a][b][c + 1][d][e + 1] +
                                            prArr[a][b][c][d + 1][e + 1] -
                                            prArr[a + 1][b][c][d][e] -
                                            prArr[a][b + 1][c][d][e] -
                                            prArr[a][b][c + 1][d][e] -
                                            prArr[a][b][c][d + 1][e] -
                                            prArr[a][b][c][d][e + 1] + prArr[a][b][c][d][e] + bArr[a][b][c][d][e];
                        }
                    }
                }
            }
        }
        int q = Integer.parseInt(bi.readLine().split("\\s")[0]);
        short l1 = 0;
        short l2 = 0;
        short l3 = 0;
        short l4 = 0;
        short l5 = 0;
        short r1 = 0;
        short r2 = 0;
        short r3 = 0;
        short r4 = 0;
        short r5 = 0;
        StringBuilder str = new StringBuilder();
        String[] cor;
        for (int i = 0; i < q; i++) {
            cor = bi.readLine().split("\\s");
            l1 = (short) (Short.parseShort(cor[0]) - 1);
            l2 = (short) (Short.parseShort(cor[1]) - 1);
            l3 = (short) (Short.parseShort(cor[2]) - 1);
            l4 = (short) (Short.parseShort(cor[3]) - 1);
            l5 = (short) (Short.parseShort(cor[4]) - 1);
            r1 = Short.parseShort(cor[5]);
            r2 = Short.parseShort(cor[6]);
            r3 = Short.parseShort(cor[7]);
            r4 = Short.parseShort(cor[8]);
            r5 = Short.parseShort(cor[9]);
            str.append(
                    prArr[r1][r2][r3][r4][r5]
                            - prArr[l1][r2][r3][r4][r5]
                            - prArr[r1][l2][r3][r4][r5]
                            - prArr[r1][r2][l3][r4][r5]
                            - prArr[r1][r2][l3][l4][r5]
                            - prArr[r1][r2][r3][r4][l5]
                            + prArr[l1][l2][r3][r4][r5]
                            + prArr[l1][r2][l3][r4][r5]
                            + prArr[l1][r2][r3][l4][r5]
                            + prArr[l1][r2][r3][r4][l5]
                            + prArr[l1][r2][r3][l4][r5]
                            + prArr[r1][l2][l3][r4][r5]
                            + prArr[r1][l2][r3][l4][r5]
                            + prArr[r1][l2][r3][r4][l5]
                            + prArr[r1][r2][l3][l4][r5]
                            + prArr[r1][r2][l3][r4][l5]
                            - prArr[r1][r2][r3][l4][l5]
                            - prArr[l1][l2][l3][r4][r5]
                            - prArr[l1][l2][r3][l4][r5]
                            - prArr[l1][l2][r3][r4][l5]
                            - prArr[l1][r2][l3][l4][r5]
                            - prArr[l1][r2][l3][r4][l5]
                            + prArr[l1][r2][r3][l4][l5]
                            + prArr[l1][l2][l3][l4][r5]
                            + prArr[l1][l2][l3][r4][l5]
                            + prArr[l1][l2][r3][l4][l5]
                            + prArr[l1][r2][l3][l4][l5]
                            + prArr[r1][l2][l3][l4][l5]
                            - prArr[l1][l2][l3][l4][l5]

            ).append("\n");
//            https://codeforces.com/edu/course/3/lesson/10/3/practice/contest/324368/problem/B
//            artiomN
//                    =XbPe8*6P_:e#.k
        }
        System.out.println(str);

    }
}
