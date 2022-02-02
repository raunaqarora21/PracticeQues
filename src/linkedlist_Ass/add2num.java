package linkedlist_Ass;
import java.util.*;

class LinkedList {
	
	Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	// O(1)
	public int size() {
		return this.size;
	}

	// O(1)
	public boolean isEmpty() {
		return this.size() == 0;
	}

	// O(1)
	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty.");
		}

		return this.tail.data;
	}

	// O(N)
	public int getAt(int idx) throws Exception {
		Node temp = this.getNodeAt(idx);
		return temp.data;
	}

	// O(N)
	private Node getNodeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		Node retVal = this.head;
		for (int i = 0; i < idx; i++) {
			retVal = retVal.next;
		}

		return retVal;
	}

	// O(1)
	public void addFirst(int data) {
		Node node = new Node(data, this.head);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}

		this.size++;
	}

	// O(1)
	public void addLast(int data) {
		Node node = new Node(data, null);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// O(n)
	public void addAt(int idx, int data) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size()) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(data, n);
			nm1.next = node;

			this.size++;
		}
	}

	// O(1)
	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.head.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.tail.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node sm2 = this.getNodeAt(this.size() - 2);
			sm2.next = null;
			this.tail = sm2;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	// O(n)
	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

		//System.out.println("END");
	}
	private static Node revereseLL(Node curr, Node prev) {
        if(curr == null) return prev;
        Node temp = curr.next;
        curr.next = prev;


        return revereseLL(temp, curr);
        
    }
	public void reverse_PR() {
		head = revereseLL(head, null);
		
		
	}

    public void reverseK(int k){
        Node ch = head;
        Node curr = head;
        
        // k = this.size - k;
        System.out.println(k);
        
        int t = k;
        while(t-- > 0){
            // System.out.println(curr.data);
            curr = curr.next;
        }

        Node tempHead = curr;

        while(curr != null && curr.next != null){
            // System.out.println(curr.data);

            curr = curr.next;

        }
        // System.out.println(curr.data);
        if(curr != null) curr.next = head;
        while(k-- > 1){
            // System.out.println(head.data);

            head = head.next;
        }

        head.next = null;

        head = tempHead;


     




    }

    public void reverse_it(){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
    }

    public int kthformlast(int n) {
        int k = n;
		Node fast = head;
		Node slow = head;

		while(k-- > 0){
			fast = fast.next;
		}

		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
    }

    

	public void partition() {
		Node odd = new Node();
		Node even = new Node();
		Node tempHead = new Node(0, odd);
		Node evenHead = new Node(0, even);
		Node curr = head;
		while(curr != null){
			Node nn = new Node(curr.data, null);
			if(curr.data % 2 != 0){
				if(odd == null){
					odd = nn;
				}else{
					odd.next = nn;
				}
				odd = odd.next;

			}else{
				if(even == null){
					even = nn;
				}else{
					even.next = nn;
				}
				even = even.next;

			}
			curr = curr.next;
		}
		odd.next = evenHead.next.next;
		head = tempHead.next.next;

	}

    public void reverseKGroups(int k) {
        if(k == 1 || head == null || head.next == null) return;
        Node root = new Node(0, null);
        root.next = head;
        Node pre = root;
        Node curr = root;
        Node nex = root;
        int size = 0;
        while(curr.next != null){
            size++;
            curr = curr.next;
        }
        // System.out.println(size);
        // int n = size / k;
        // System.out.println(n);
        while(size >= k){
            curr = pre.next;
            nex = curr.next;
            // System.out.println(curr.val + " "+ nex.val);
            for(int i = 1; i < k; i++){
                //  Node nex = curr.next;
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
                // System.out.println(nex.val);
                
            }
            size -= k;
            pre = curr;
        }
        head = root.next;
    }
}
public class add2num{


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//int M = scn.nextInt();

        while(T-- > 0){
            LinkedList list = new LinkedList();
            LinkedList list2 = new LinkedList();
    
            int n = sc.nextInt();
    
            for (int i = 0; i < n; i++) {
                list.addLast(sc.nextInt());
            }
            int m = sc.nextInt();

            for (int i = 0; i < m; i++) {
                list2.addLast(sc.nextInt());
            }
            // System.out.println(list.head.data);
            Node temp = merge(list.head, list2.head);
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

		
	

        // list.reverse_PR();
        // list2.reverse_PR();

        // LinkedList ll = addNum(list.head, list2.head);
        

      
        

		// list.reverse_it();
		// list.display();
	}

    private static Node merge(Node l1, Node l2) {
    

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.data <= l2.data){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }



     
    }

    private static LinkedList addNum(Node head, Node head2) {
        
        LinkedList tempHead = new LinkedList();

        

        Node c1 = head;
        Node c2 = head2;
        int carry = 0;

        while(c1 != null || c2 != null || carry == 1){
            int v1 = c1 == null ? 0 : c1.data;
            int v2 = c2 == null ? 0 : c2.data;

            int rem = ( v1 + v2 + carry ) % 10;
            tempHead.addFirst(rem);
            carry = ( v1 + v2 + carry ) / 10;

            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;

          


        }

        return tempHead;



    }
}
class Node {
    int data;
    Node next;
    Node() {
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

   
}


