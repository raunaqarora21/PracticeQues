package dpAss;

import java.util.Scanner;

public class tiling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[]dp = new int[n + 1];
        int ans = solve(n, m, dp);
        System.out.println(ans);
    }

    private static int solve(int n, int m,int[]dp) {
       
        for (int i = 1; i < dp.length; i++) {
            if(i < m) dp[i] = 1;
            else if(i == m) dp[i] = 2;
            else{
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }

        return dp[n] % 10000007;
    }
    
}
