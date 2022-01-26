package ds.doublyLinkedList;
//Node class
class Nodee{
    int data;
    Nodee next;
    Nodee prev;
    public Nodee(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList {
    //implement the methods of the DoublyLinkedList class
    private Nodee head;
    DoublyLinkedList(){
        head = null;
    }

    public void insertAtHead(int data){
        Nodee newNode = new Nodee(data);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }
      
    }

    //insert at the end of the list
    public void insertAtEnd(int data){
        Nodee newNode = new Nodee(data);
        if(head == null){
            head = newNode;
        }else{
            Nodee temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = null;
        }
       
    }

    //delete at the head of the list
    public void deleteAtHead(){
       if(head == null){
           System.out.println("List is empty");
        }else{
            head = head.next;
            head.prev = null;
        }
    }

    //delete at the end of the list
    public void deleteAtEnd(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Nodee temp = head;
            if(temp.next == null){
                head = null;
            }else{
                while(temp.next.next != null){
                    temp = temp.next;
                }
                temp.next = null;
            }
           
        }
    }
            

    //display
    public void display(){
        Nodee temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtHead(30);
        // dll.insertAtHead(40);
        // dll.insertAtHead(50);
        // dll.insertAtHead(60);
        // dll.insertAtEnd(70);
        // dll.deleteAtHead();
        dll.deleteAtEnd();
        dll.deleteAtEnd();

        dll.deleteAtEnd();
        dll.deleteAtEnd();

        dll.display();
        
    }



    
}
