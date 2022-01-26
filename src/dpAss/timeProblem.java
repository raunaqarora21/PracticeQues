package dpAss;

import java.util.Scanner;
import java.util.Stack;

public class timeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            s1.push(arr[i]);
        }
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            s2.push(arr[i]);
        }
        int ans = solve(s1, s2);
        System.out.println(ans);
        sc.close();
    }

    private static int solve(Stack<Integer> s1, Stack<Integer> s2) {
        int ans = 0;
        
        while(!s1.isEmpty()){
            int v1 = s1.pop();
            int v2 = s2.peek();
            if(v1 != v2){
                insertAtBottom(s1, v1);

                
            }else{
                s2.pop();
            }
            ans++;
        }
        return ans;
    }

    private static void insertAtBottom(Stack<Integer> s1, int v1) {
        if(s1.isEmpty()){
            s1.push(v1);
        }else{
            int x = s1.peek();
            s1.pop();
            insertAtBottom(s1, v1);
            s1.push(x);

        }
    }
}
