package linkedlist_Ass;

import java.util.Scanner;

public class mergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l = new LinkedList();
        for (int j = 0; j < n; j++) {
            int item = sc.nextInt();
            l.addLast(item);
        }


        l.head = merge(l.head);
        l.display();
    }

    private static Node merge(Node head) {
        if(head == null || head.next == null) return head;
        Node mid = findMid(head);
        Node mid_next = mid.next;
        mid.next = null;
        Node l1 = merge(head);
        Node l2 = merge(mid_next);

        return mergeHelper(l1, l2);
        

    }

    private static Node mergeHelper(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.data <= l2.data){
            l1.next = mergeHelper(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeHelper(l1, l2.next);
            return l2;
        }
        
    }

    private static Node findMid(Node head) {
        if(head == null) return head;
        Node slow = head;
        Node fast = head;

        while(slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
}
