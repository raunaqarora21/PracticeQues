package linkedlist_Ass;
import java.util.Scanner;

// import linkedlist_Ass.LinkedList;
public class intersectionPt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] n1 = new int[n];

        for (int i = 0; i < n; i++) {
            n1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] n2 = new int[m];


        for (int j = 0; j < m; j++) {
            n2[j] = sc.nextInt();
        }
        int ans = 0;

        for (int i = 0; i < n1.length && ans == 0; i++) {
            for (int j = 0; j < n2.length; j++) {
                if(n1[i] == n2[j]){
                    ans = n1[i];
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}
