package dpAss;

import java.util.Arrays;
import java.util.Scanner;

public class lcs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        int[][] dp = new int[n][m];
        for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
        int ans = LCS(arr1, arr2, 0, 0, dp);
        int max = Math.max(n,m);
        if(ans + k > max) ans = max;
        else ans += k;
        System.out.println(ans);
        sc.close();
    }

    private static int LCS(int[] arr1, int[] arr2, int i, int j, int [][] dp) {

        if(i >= arr1.length || j >= arr2.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans =  0;
        if(arr1[i] == arr2[j]){
            ans = 1 + LCS(arr1, arr2, i + 1, j + 1, dp);
        }else{
            int v1 = LCS(arr1, arr2, i + 1, j, dp);
            int v2 = LCS(arr1, arr2, i, j + 1, dp);
            ans = Math.max(v1, v2);
        }


        return dp[i][j] = ans;
    }

    
}
