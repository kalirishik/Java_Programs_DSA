class Node5{
    Node5 prev;
    Node5 next;
    int val;
    Node5(int val){
        this.val=val;
    }
    Node5(int val,Node5 next,Node5 prev){
        this.val=val;
        this.next=next;
        this.prev=prev;
    }
}
class DLL{
    Node5 head,tail;
    public void insert(int val) {
        Node5 newNode = new Node5(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertFirst(int val){
        Node5 node=new Node5(val);
        node.next=head;
        node.prev=null;
        if(head!=null)
            head.prev=node;
        head=node;
    }
    public void display(){
        Node5 temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public void displayReverse(Node5 temp){
        if(temp==null)
            return;
        displayReverse(temp.next);
        System.out.print(temp.val+" -> ");
    }
    public void displayReverse(){
        Node5 temp=head;
        Node5 tail=null;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            tail=temp;
            temp=temp.next;
        }
        System.out.println("END");
        while(tail!=null){
            System.out.print(tail.val+" -> ");
            tail=tail.prev;
        }
        System.out.println("END");

    }
    public void insertLast(int val) {
        Node5 newNode = new Node5(val);
//        if (head == null) {
//            head = newNode;
//            return;
//        }
        Node5 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }
    public void insertAfter(Node5 prevNode, int val) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node5 newNode = new Node5(val);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }
    public void deleteAt(int pos){
        Node5 temp=head;
        for(int i=0;i<pos-1;i++)
            temp=temp.next;
        temp.next=temp.next.next;
        temp.next.prev=temp;
    }


}
public class DoublyLinkedList {
    public static void main(String[] args) {
        DLL l=new DLL();
//        l.insertFirst(5);
//        l.insertFirst(6);
//        l.insertFirst(7);
//        l.insertFirst(8);
//        l.display();
//        l.insertLast(9);
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.display();
        System.out.println();
        l.deleteAt(1);
        l.display();
//        l.displayReverse(l.head);
//        l.displayReverse();
    }
}
