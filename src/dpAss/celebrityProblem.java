package dpAss;
import java.util.*;
public class celebrityProblem {
    

    public static void main(String args[]) {
		Stack<Integer> st = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int [][] mat = new int[n][n];

		for(int i = 0; i < n; i++){
			for (int j = 0; j < mat.length; j++) {
                mat[i][j] = sc.nextInt();
            }
		}
		st.push(0);

		for(int i = 1; i < n; i++){
            if(i == st.peek()) continue;
            int el = st.pop();
            if(mat[el][i] != 0 || mat[i][el] != 1){
                st.push(i);

            }
            else st.push(el);

        }
        int ans =st.pop();
        for (int i = 0; i < mat.length; i++) {
            if(ans == i ) continue;
            if(mat[ans][i] != 0 || mat[i][ans] != 1){
                ans = -1;
                break;
            }
        }

        if(ans == -1){
            System.out.println("No Celebrity");
        }else{
            System.out.println(ans);
        }
        sc.close();


    }

    
}
