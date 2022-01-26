package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class KnapSack{
    static int[][] board;
    static int[] x;
    public static void main(String[] args) {
        int[] profit =  new int[]{60,100,20,40,20};
        int[] deadline =  new int[]{2,1,3,2,1};
      

        int n = 6; 
        int w = 3;
        // knapsack(profit, weights, n, w);
        // fractionalKnapsack(profit, weights, n, w);
        // Job[] jobs = new Job[n];
        // for (int i = 0; i < jobs.length; i++) {
        //     jobs[i] =  new Job(profit[i], deadline[i]);
        // }

        // jobSequencing(jobs, profit, w);
        // Activity[] a = new Activity[10];
        // int[] start = new int[]{1,2,3,4,7,8,9,9,11,12};
        // int[] end = new int[]{3,5,4,7,10,9,11,13,12,14};

        // for (int i = 0; i < a.length; i++) {
        //     a[i] = new Activity(start[i], end[i], "a" + (i + 1));
        // }
        // activtySelection(a);
        board = new int[4][4];
        x = new int[4];
        nQueens(0);
    }
        
        
    

    private static void nQueens(int k) {
        if(k == board.length) return;
       
        for (int i = 0; i < board.length; i++) {
            if(isSafe(k, i)){
                x[k] = i;
                if(k == board.length){
                    // print(board);
                    for (int j = 0; j < board.length; j++) {
                        System.out.print(x[j] + " ");
                    }
                    System.out.println();
                }else{
                    nQueens(k + 1);
                }

            }
        }
        
    }




    private static boolean isSafe(int k, int i) {
        for (int j = 0; j < k - 1; j++) {
            if(x[j] == i || (Math.abs(x[j] - i) == Math.abs(j - k))) return false;
        }
        return true;
    }




    private static void activtySelection(Activity[] a) {

        Arrays.sort(a, new Comparator<Activity>() {

            @Override
            public int compare(Activity o1, Activity o2) {
                // TODO Auto-generated method stub
                return o1.end - o2.end;
            }

            
        });

        int start = 0;
        int end = 0;
        LinkedList<String> ans = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if(start == 0 || end <= a[i].start){
                start = a[i].start;
                end = a[i].end;
                ans.add(a[i].id);
            }
        }
        System.out.println(ans);

    }




    private static void jobSequencing(Job[] jobs, int[] profit, int w) {
        int[] arr = new int[w];
        Arrays.sort(jobs, new Comparator<Job>() {

            @Override
            public int compare(Job o1, Job o2) {
                // TODO Auto-generated method stub
                return o2.profit - o1.profit;
            }
            
        });
        for (Job j : jobs) {
            System.out.println(j.profit);
        }
        int ans = 0;
        for (int i = 0; i < jobs.length; i++) {
            for (int j = Math.min(jobs[i].deadline - 1, w -1); j >= 0; j--) {
                if(arr[j] == 0){
                    arr[j] = jobs[i].profit;
                    ans += jobs[i].profit;
                    break;
                }
               
            }
            
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(ans);

    }




    private static void fractionalKnapsack(int[] val, int[] weights, int n, int w) {
        Pair[] arr = new Pair[n];
        for (int i = 0; i < weights.length; i++) {
            arr[i ]= new Pair(val[i], weights[i]);
         }
         Arrays.sort(arr, new Comparator<Pair>() {

            @Override
            public int compare(Pair o1, Pair o2) {
             
                return o2.cost.compareTo(o1.cost);
            }
             
         });
        int ans = 0;
        for (Pair pair : arr) {
            System.out.println(pair.wt);
            if((w - pair.wt) >= 0){
                w -= pair.wt;
                ans += pair.val;
            }else{
                double rem_wt = ((double)w/ (double)pair.wt);
                ans += rem_wt*pair.val;
                w = (int)(w - rem_wt*pair.wt);
            
                break;
            }
        }
        System.out.println(ans);
    }

    private static void knapsack(int[] profit, int[] weights, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                // System.out.println(i + " " + j);
               if(weights[i - 1] <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + profit[i - 1]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
    }



    private static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }System.out.println();
        }
    }

 
  

   
}
class Pair{
    int val;
    int wt;
    Double cost;
    Pair(int price, int weight){
      this.val = price;
      this.wt = weight;
      cost = new Double((double) val/ (double) wt);   
    }
  }

  class Job{
      int profit;
      int deadline;
    public Job(int profit, int deadline) {
        this.profit = profit;
        this.deadline = deadline;
    }

   
      
  }
  class Activity{
    int start;
    int end;
    String id;
    public Activity(int start, int end, String id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }
    
}
