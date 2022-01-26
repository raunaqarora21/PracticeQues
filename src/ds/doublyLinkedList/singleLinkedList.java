// package ds.doublyLinkedList;
// class Node{
//     char data;
//     Node next;
    
//     public Node(char data) {
//         this.data = data;
//         this.next = null;
//     }
// }

// class Stack {
//     private Node top;
//     Stack(){
//         top = null;
//     }
//     public void push(char data){
//         Node newNode = new Node(data);
//         newNode.next = top;
//         top = newNode;
//     }
//     public char pop(){
//         if(top == null){
//             System.out.println("Stack is empty");
//             return ' ';
//         }
//         char data = top.data;
//         top = top.next;
//         return data;
//     }
//     public char peek(){
//         if(top == null){
//             System.out.println("Stack is empty");
//             return ' ';
//         }
//         return top.data;
//     }
// }

// //function to reverse a string using stack
// class ReverseString {
//     public static void main(String[] args) {
//         Stack stack = new Stack();
//         stack.push('h');
//         stack.push('e');
//         stack.push('l');
//         stack.push('l');
//         stack.push('o');
//         while(stack.peek() != ' '){
//             System.out.print(stack.pop());
//         }
//     }
// }