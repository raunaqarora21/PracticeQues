package dpAss;

import java.util.Scanner;
import java.util.Stack;

public class stockspan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = new int[n];
        solve(arr, ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.err.print("END");
        System.out.println();
        sc.close();
    }

    private static void solve(int[] arr, int[] ans) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int c = 1;
            while(!st.isEmpty() && arr[i] > arr[st.peek()] ){
               
                c+=ans[st.pop()];
            }
            ans[i] = c;
            st.push(i);


        }
    }
    
}
