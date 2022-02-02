package linkedlist_Ass;

import java.util.Scanner;

public class kAppend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l = new LinkedList();
        for (int j = 0; j < n; j++) {
            int item = sc.nextInt();
            l.addLast(item);
        }

        int k = sc.nextInt();
        k = k % n;
        // System.out.println(k);
        if(k != 0) l.reverseK(n - k);
        l.display();


    }
}
