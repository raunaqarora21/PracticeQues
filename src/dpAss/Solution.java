package dpAss;
import java.util.*;

public class Solution {
    public static int[] dNums(int[] A, int B) {
        int n = A.length;
        if(B > n) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < B; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(map.size());

        for(int i = B; i < n; i++){
            map.put(A[i - B], map.get(A[i - B]) - 1);
            if(map.get(A[i - B]) == 0){
                map.remove(A[i - B]);
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            ans.add(map.size());
        }

        int[] res = new int[ans.size()];
        int x = 0;
        for(int e : ans){
            res[x++] = e;
        }

        return res;


        
    }

    public static void main(String[] args) {
        int[] ans = dNums(new int[]{1, 2, 1, 3, 4, 3}, 3);
        System.out.println(Arrays.toString(ans));
    }
}

