package dpAss;

import java.util.Scanner;
import java.util.Stack;

public class formMinSub{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String w = sc.next();
            String s = "";
            for (int i = 0; i < 8; i++) {
                int ch = w.charAt(i) - '0';
                s += ch % 2 == 0 ? 'I' : 'D';
            }
            solve(s);
        }
        

        
    }

    private static void solve(String string) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= string.length(); i++) {
            stack.push(i + 1);
            if(i == string.length() || string.charAt(i) == 'I'){
                while(!stack.isEmpty()) System.out.print(stack.pop());
            }
        }
        System.out.println();


    }
}