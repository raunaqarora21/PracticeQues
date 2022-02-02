package linkedlist_Ass;
import java.util.Scanner;


public class partition {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        int n = scn.nextInt();

        for (int j = 0; j < n; j++) {
            int item = scn.nextInt();
            ll.addLast(item);
        }
     
        ll.partition();
        ll.display();
    }
 
}
