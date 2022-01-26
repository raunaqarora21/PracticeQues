package ds.doublyLinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
    }
    
}

class BFSSearch{



public static void main(String[] args) {
    TreeNode head;
    head = new TreeNode(40);
    head.left = new TreeNode(20);
    head.right = new TreeNode(60);
    head.left.left = new TreeNode(10);
    head.left.right = new TreeNode(30);
    head.right.left = new TreeNode(50);
    head.right.right  = new TreeNode(70);
    BFS(head);
}

public static void BFS(TreeNode head){
    Queue<TreeNode> q = new LinkedList<>();
    if(head == null ) return;
    q.add(head);
    while(q.size() > 0){
        int size = q.size();
        for (int i = 0; i < size; i++) {
            TreeNode rem = q.remove();
            System.out.print(rem.data + " ");
            if(rem.left != null) q.add(rem.left);
            if(rem.right != null) q.add(rem.right);
        }
        System.out.println();
    }
}

public static void DFS(TreeNode head){
    if(head == null) return;
    Stack<TreeNode> stack = new Stack<>();

    stack.push(head);
    TreeNode curr = head;
    while(stack.size() > 0 || curr != null){
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        System.out.print(curr.data + " ");
        curr = curr.right;
    }

 }


 public static void BFS2(TreeNode root){
    if(root == null) return;
    int height = height(root);
    for (int i = 0; i <= height; i++) {
        printCurrentLevel(root, i);
    }
 }

 private static void printCurrentLevel(TreeNode root, int level) {
     if(root == null) return ;
     if(level == 1){
         System.out.print(root.data + " ");
     }else{
        printCurrentLevel(root.left, level - 1);
        printCurrentLevel(root.right, level - 1);

     }

}

public static int height(TreeNode root){
     if(root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
 }
}