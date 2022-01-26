package dpAss;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.Stack;

public class cards{
    static ArrayList<Integer> prime;
    public static void main(String[] args) {
        prime = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
        sieve();
        solve(arr, q);
        // System.out.println(prime);
       
        sc.close();
    }

    private static void solve(long[] arr, int q) {
        Stack<Long> st = new Stack<>();
        Stack<Long> temp = new Stack<>();
        Stack<Long> ans = new Stack<>();



        // ArrayList<Long> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(arr[i]);
        }
        // System.out.println(st);
        for (int i = 0; i < q; i++) {
            int num = prime.get(i);
            // System.out.println(num);
            
            int size = st.size();
            while(size-- > 0){
                long v = st.pop();
                // System.out.println(v);

                if(v % num == 0) ans.push(v);
                else temp.push(v);

            }
            st = temp;
            temp = new Stack<>();
            // System.out.println(st);
			while(ans.size() > 0){
				System.out.println(ans.pop());
			}
			
            // System.out.println(st.peek());
        }

       
       
        // ans = new ArrayList<>();
        while(!st.isEmpty()) System.out.println(st.pop());
        // Collections.reverse(ans);
       
        

        // System.out.println(ans);
    }

    private static void sieve() {
        boolean[] sieve = new boolean[100000];

        sieve[2] = true;
        for (int i = 1; i < sieve.length; i++) {
            sieve[i] = true;
        }

        for(int i = 2; i * i < sieve.length; i++){
            if(sieve[i] == true){
                for(int j = i * i; j < sieve.length; j += i){
                    sieve[j] = false;
                }
            }
           
        }
        for (int i = 2; i < sieve.length; i++) {
            if(sieve[i] == true) prime.add(i);
        }
    }
}
