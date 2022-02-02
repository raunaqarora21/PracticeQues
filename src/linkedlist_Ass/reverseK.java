package linkedlist_Ass;

import java.util.Scanner;

public class reverseK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        LinkedList l = new LinkedList();
        for (int j = 0; j < n; j++) {
            int item = sc.nextInt();
            l.addLast(item);
        }

        l.reverseKGroups(k);
        l.display();
    }
}
