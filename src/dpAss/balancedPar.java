package dpAss;

import java.util.Scanner;
import java.util.Stack;

public class balancedPar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        boolean ans =solve(s);

        System.out.println(ans ? "Yes" : "No");
       
    }

    private static boolean solve(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '}' || ch == ']'){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                char rem = st.pop();
                if(ch == ')' && rem != '(' ) return false;
                if(ch == '}' && rem != '{' ) return false;
                if(ch == ']' && rem != '[' ) return false;

            }
        }
        return st.size() == 0;
    }
    
}
