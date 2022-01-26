package classPrograms.Tree;

import java.util.Stack;

class Traversals{
    static TreeNode root;
    class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;
        public TreeNode(int data){
            this.data = data;
    
        }
    }

    public void createBinaryTree(){
        TreeNode firstNode = new TreeNode(1);
        TreeNode secondNode = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth= new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        root = firstNode;
        firstNode.left = secondNode;
        firstNode.right = third;
        secondNode.left = fourth;
        secondNode.right = fifth;
        third.left = sixth;
        third.right = seventh;


    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public void preOrderIterative(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }
    

    public static void main(String[] args) {
        Traversals bt = new Traversals();
        bt.createBinaryTree();
        bt.preOrder(root);
    }
}



