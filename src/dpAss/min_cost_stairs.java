package dpAss;

import java.util.Arrays;
import java.util.Scanner;

public class min_cost_stairs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();

        // while(t-- > 0){
            int n = sc.nextInt();

            int m = sc.nextInt();
            int[][] cost = new int[n][m];
            for (int i = 0; i < cost.length; i++) {
                for (int j = 0; j < cost[0].length; j++) {
                    cost[i][j] = sc.nextInt();
                
                }

                
            }
            int dp[][] = new int[n][m];
            int ans = 0;

            ans = solve(cost, dp, 0, 0);

            
            // System.out.println(Arrays.toString(dp));
            System.out.println(ans);

        // }


        
        
        sc.close();
    }

    private static int solve(int[][] mat, int[][] dp, int i, int j) {

        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) return Integer.MAX_VALUE;
        if(i == mat.length - 1 && j == mat[0].length - 1) return mat[i][j] + dp[i][j];
        if(dp[i][j] != 0) return dp[i][j];
       
        int v1 = solve(mat, dp, i, j +1);
        int v2 = solve(mat, dp, i + 1, j);

        // int v3 = solve(mat, dp, i + 1, j +1);
       



        dp[i][j] = Math.min(v1, v2) + mat[i][j];
        return dp[i][j];
    }
}