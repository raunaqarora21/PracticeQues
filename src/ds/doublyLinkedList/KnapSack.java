//implement fractional knapsack
package ds.doublyLinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class KnapSack {
    public static void main(String[] args) {
        // int[] wt = {5, 3, 2, 6, 1};
        // int[] val = {3, 5, 7, 8, 10};
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];

        
        for (int index = 0; index < wt.length; index++) {
          wt[index] = sc.nextInt();
        }
        for (int index = 0; index < wt.length; index++) {
          val[index] = sc.nextInt();
        }
        dpMethod(wt, val, W, n);
        // fractionalKnapsack(wt, val, W, n);
        
    }

    private static void fractionalKnapsack(int[] wt, int[] val, int w, int n) {
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Pair(val[i], wt[i]);
        }

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.val/o2.wt - o1.val/o1.wt;
            }
        });

        for (Pair pair : arr) {
          System.out.println(pair.val + " " + pair.wt);
        }
      
    

        
        

       
        

      
      }

    public static void dpMethod(int[] wt,  int[] val, int W, int n){
      int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}

class Pair{
  int val;
  int wt;
  Pair(int price, int weight){
    this.val = price;
    this.wt = weight;
  }
}
