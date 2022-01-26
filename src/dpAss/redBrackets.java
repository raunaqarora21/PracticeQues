package dpAss;

import java.util.Scanner;
import java.util.Stack;

public class redBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.next();
            boolean ans = solve(s);
            System.out.println(ans ? "Not Duplicates" : "Duplicate");
        }
        sc.close();
    }

    private static boolean solve(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);

            }else if(ch == ')'){
                if(st.peek() == '(') return false;
                while(st.peek() != '(') st.pop();
                st.pop();
            }else{
                st.push(ch);
            }
        }
        return true;
    }
    
}
