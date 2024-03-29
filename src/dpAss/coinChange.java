package dpAss;

import java.util.Scanner;

public class coinChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[]{1,3,4};
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0){
                    dp[i] += dp[i - coins[j]];
                }
            }
        }

        System.out.println(dp[n]);

            
    }
    
}
