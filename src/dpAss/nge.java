package dpAss;

import java.util.Scanner;
import java.util.Stack;

public class nge {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = new int[n];
            solve(arr, ans);
            for (int i = 0; i < ans.length; i++) {
                System.out.println(arr[i] + "," + ans[i]);
            }

        }
       
        // System.out.println();
        sc.close();
    }

    private static void solve(int[] arr, int[] ans) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                ans[st.pop()] = arr[i];
            }

            st.push(i);
            
        }

        System.out.println(st);
        while(!st.isEmpty()){
            int idx = st.pop();
            ans[idx] = -1;
            // if(st.size() > 0){
            //     int temp = st.pop();
            //     ans[idx] = arr[temp];
            //     st.push(temp);
            // }
        }
    }
    
}
