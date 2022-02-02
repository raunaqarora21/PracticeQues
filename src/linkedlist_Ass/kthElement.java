// package linkedlist_Ass;
// import java.util.*;
// class LinkedList {
// 	class Node {
// 		int data;
// 		Node next;

// 		Node(int data, Node next) {
// 			this.data = data;
// 			this.next = next;
// 		}

// 		Node() {
// 		}
// 	}

// 	Node head;
// 	private Node tail;
// 	private int size;

// 	public LinkedList() {
// 		this.head = null;
// 		this.tail = null;
// 		this.size = 0;
// 	}

// 	public LinkedList(Node head, Node tail, int size) {
// 		this.head = head;
// 		this.tail = tail;
// 		this.size = size;
// 	}

// 	// O(1)
// 	public int size() {
// 		return this.size;
// 	}

// 	// O(1)
// 	public boolean isEmpty() {
// 		return this.size() == 0;
// 	}

// 	// O(1)
// 	public int getFirst() throws Exception {
// 		if (this.isEmpty()) {
// 			throw new Exception("List is empty.");
// 		}

// 		return this.head.data;
// 	}

// 	// O(1)
// 	public int getLast() throws Exception {
// 		if (this.isEmpty()) {
// 			throw new Exception("List is empty.");
// 		}

// 		return this.tail.data;
// 	}

// 	// O(N)
// 	public int getAt(int idx) throws Exception {
// 		Node temp = this.getNodeAt(idx);
// 		return temp.data;
// 	}

// 	// O(N)
// 	private Node getNodeAt(int idx) throws Exception {
// 		if (this.isEmpty()) {
// 			throw new Exception("List is empty");
// 		}

// 		if (idx < 0 || idx >= this.size()) {
// 			throw new Exception("Invalid arguments");
// 		}

// 		Node retVal = this.head;
// 		for (int i = 0; i < idx; i++) {
// 			retVal = retVal.next;
// 		}

// 		return retVal;
// 	}

// 	// O(1)
// 	public void addFirst(int data) {
// 		Node node = new Node(data, this.head);

// 		if (this.size() == 0) {
// 			this.head = node;
// 			this.tail = node;
// 		} else {
// 			this.head = node;
// 		}

// 		this.size++;
// 	}

// 	// O(1)
// 	public void addLast(int data) {
// 		Node node = new Node(data, null);

// 		if (this.size() == 0) {
// 			this.head = node;
// 			this.tail = node;
// 		} else {
// 			this.tail.next = node;
// 			this.tail = node;
// 		}

// 		this.size++;
// 	}

// 	// O(n)
// 	public void addAt(int idx, int data) throws Exception {
// 		if (idx < 0 || idx > this.size()) {
// 			throw new Exception("Invalid arguments");
// 		}

// 		if (idx == 0) {
// 			this.addFirst(data);
// 		} else if (idx == this.size()) {
// 			this.addLast(data);
// 		} else {
// 			Node nm1 = this.getNodeAt(idx - 1);
// 			Node n = nm1.next;

// 			Node node = new Node(data, n);
// 			nm1.next = node;

// 			this.size++;
// 		}
// 	}

// 	// O(1)
// 	public int removeFirst() throws Exception {
// 		if (this.isEmpty()) {
// 			throw new Exception("List is empty");
// 		}

// 		int retVal = this.head.data;

// 		if (this.size() == 1) {
// 			this.head = null;
// 			this.tail = null;
// 		} else {
// 			this.head = this.head.next;
// 		}

// 		this.size--;
// 		return retVal;
// 	}

// 	// O(n)
// 	public int removeLast() throws Exception {
// 		if (this.isEmpty()) {
// 			throw new Exception("List is empty");
// 		}

// 		int retVal = this.tail.data;

// 		if (this.size() == 1) {
// 			this.head = null;
// 			this.tail = null;
// 		} else {
// 			Node sm2 = this.getNodeAt(this.size() - 2);
// 			sm2.next = null;
// 			this.tail = sm2;
// 		}

// 		this.size--;
// 		return retVal;
// 	}

// 	// O(n)
// 	public int removeAt(int idx) throws Exception {
// 		if (this.isEmpty()) {
// 			throw new Exception("List is empty");
// 		}

// 		if (idx < 0 || idx >= this.size()) {
// 			throw new Exception("Invalid arguments");
// 		}

// 		if (idx == 0) {
// 			return this.removeFirst();
// 		} else if (idx == this.size() - 1) {
// 			return this.removeLast();
// 		} else {
// 			Node nm1 = this.getNodeAt(idx - 1);
// 			Node n = nm1.next;
// 			Node np1 = n.next;

// 			nm1.next = np1;
// 			this.size--;

// 			return n.data;
// 		}
// 	}

// 	// O(n)
// 	public void display() {
// 		Node node = this.head;

// 		while (node != null) {
// 			System.out.print(node.data + " ");
// 			node = node.next;
// 		}

// 		//System.out.println("END");
// 	}
// 	private static Node revereseLL(Node curr, Node prev) {
//         if(curr == null) return prev;
//         Node temp = curr.next;
//         curr.next = prev;


//         return revereseLL(temp, curr);
        
//     }
// 	public void reverse_PR() {
// 		head = revereseLL(head, null);
		
		
// 	}

//     public void reverse_it(){
//         Node prev = null;
//         Node curr = head;
//         while(curr != null){
//             Node temp = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = temp;
//         }
//         head = prev;
//     }

//     public int kthformlast(int n) {
//         int k = n;
// 		Node fast = head;
// 		Node slow = head;

// 		while(k-- > 0){
// 			fast = fast.next;
// 		}

// 		while(fast != null){
// 			slow = slow.next;
// 			fast = fast.next;
// 		}

// 		return slow.data;
//     }

// 	public void partition() {
// 		Node odd = new Node();
// 		Node even = new Node();
// 		Node tempHead = new Node(0, odd);
// 		Node evenHead = new Node(0, even);
// 		Node curr = head;
// 		while(curr != null){
// 			Node nn = new Node(curr.data, null);
// 			if(curr.data % 2 != 0){
// 				if(odd == null){
// 					odd = nn;
// 				}else{
// 					odd.next = nn;
// 				}
// 				odd = odd.next;

// 			}else{
// 				if(even == null){
// 					even = nn;
// 				}else{
// 					even.next = nn;
// 				}
// 				even = even.next;

// 			}
// 			curr = curr.next;
// 		}
// 		odd.next = evenHead.next.next;
// 		head = tempHead.next.next;

// 	}
// }
// public class kthElement{


// 	public static void main(String[] args) throws Exception {
		
// 		Scanner sc = new Scanner(System.in);
// 		// int N = scn.nextInt();
// 		//int M = scn.nextInt();

		
// 		LinkedList list = new LinkedList();
//         int item = sc.nextInt();

//         while (item != -1) {
// 			list.addLast(item);
// 			item = sc.nextInt();
			

// 		}
//         int n = sc.nextInt();
//         System.out.println(list.kthformlast(n));

// 		// list.reverse_it();
// 		// list.display();
// 	}
// }

