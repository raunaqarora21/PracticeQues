package dpAss;

import java.util.Arrays;
import java.util.Scanner;

public class valentineMagic{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] boys = new int[n];
        int[] girls = new int[m];
        for (int i = 0; i < boys.length; i++) {
            boys[i] = sc.nextInt();
        }
        for (int i = 0; i < girls.length; i++) {
            girls[i] = sc.nextInt();
        }
        int[][] dp = new int[n][m];
        Arrays.sort(boys);
        Arrays.sort(girls);
        for(int[] a : dp) Arrays.fill(a, -1);
        System.out.println(solve(boys, girls, 0, 0, dp));  
    }

    private static int solve(int[] boys, int[] girls, int i, int j, int[][] dp) {

        if(boys.length == i) return 0;
        if(girls.length == j) return 10000000;
        if(dp[i][j] != -1) return dp[i][j];

        int v1 = Math.abs(boys[i] - girls[j]) + solve(boys, girls, i + 1, j + 1, dp);
        int v2 = solve(boys, girls, i, j + 1, dp);

        return dp[i][j] = Math.min(v1, v2);
    }
}