package dpAss;

import java.util.Arrays;
import java.util.Scanner;

public class editDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] a = s.split(" ");
        String word1 = a[2];
        String word2 = a[a.length - 1];
        // System.out.println(word1 + " " + word2);
        
        StringBuffer sb = new StringBuffer(word1);
        StringBuffer sb2 = new StringBuffer(word2);

        
        sb.deleteCharAt(0);
        sb.delete(sb.length() - 2, sb.length());
        word1 = sb.toString();

        sb2.deleteCharAt(0);
        sb2.deleteCharAt(sb2.length() - 1);
        word2 = sb2.toString();
        // System.out.println(word1 + " " + word2);
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] v: dp) Arrays.fill(v, -1);
        int ans = solve(word1, word2, 0, 0, dp);
        System.out.println(ans);

        sc.close();
    }

    private static int solve(String word1, String word2, int i, int j, int[][] dp) {
        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = solve(word1, word2, i + 1, j + 1, dp);
        }else{
            int insert = 1 + solve(word1, word2, i, j + 1, dp);
            int delete = 1 + solve(word1, word2, i + 1, j, dp);
            int replace = 1 + solve(word1, word2, i + 1, j + 1, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }




    }
    
}
