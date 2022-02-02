package practice;
import java.util.*;
public class powerSet {
    public static void main(String[] args) {
        int number = 345;
        String t = Integer.toString(number);

        int n = t.length();
        int r = (int) Math.pow(2, n); 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int num = 0; num < r; num++) {
            ArrayList<Integer> temp = new ArrayList<>(); 
            for (int i = 0; i < n; i++) {
                
                if((num & (1 << i)) != 0){
                    temp.add(t.charAt(i) - '0');
                }
            }
            ans.add(temp);
        }
        System.out.println(ans);

    }
}
