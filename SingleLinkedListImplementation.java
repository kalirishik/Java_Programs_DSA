import java.util.*;
class Node3{
    int data;
    Node3 next;
    Node3(int data){
        this.data=data;
    }
}
class Linkedlist{
    Node3 head,tail;
    public void insert(int data){
        Node3 n=new Node3(data);
        n.next=null;
        if(head==null){
            head=n;
            tail=n;
        }
        else{
            tail.next=n;
            tail=n;
        }
    }
    public void display(){
        if(head==null)
            System.out.println("List Empty");
        else{
            Node3 temp=head;
            while(temp!=null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
    public  Node3 rotateRight(int k) {
        if(head == null||head.next == null||k == 0)
            return head;
        //calculating length
        Node3 temp = head;
        int length = 1;
        while(temp.next != null) {
            ++length;
            temp = temp.next;
        }
        //link last node to first node
        temp.next = head;
        k = k%length; //when k is more than length of list
        int end = length-k; //to get end of the list
        while(end--!=0)
            temp = temp.next;
        //breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;

        return head;
    }
    public void insertBeg(int data){
        Node3 n=new Node3(data);
        n.next=head;
        head=n;
    }
    public void insertAt(int pos,int data){
        Node3 n=new Node3(data);
        Node3 temp=head;
        for(int i=0;i<pos-1;i++)
                temp=temp.next;
        n.next=temp.next;
        temp.next=n;
    }
    public void deleteBeg(){
        Node3 temp=head;
        head=head.next;
        temp.next=null;
    }
    public void deleteEnd(){
        Node3 temp=head;
        while(temp.next!=tail)
            temp=temp.next;
        temp.next=null;
        tail=temp;
    }
    public void deleteAt(int pos){
        Node3 temp=head;
        for(int i=0;i<pos-1;i++)
            temp=temp.next;
        temp.next=temp.next.next;
    }
    public void displayReverse(Node3 temp){
        if(temp==null)
            return;
        displayReverse(temp.next);
        System.out.print(temp.data+" ");
    }
    public void mergeList(Linkedlist node){
        if(node.head==null)
            return;
        tail.next=node.head;
        tail=node.tail;

    }
    public void reverseList() {
        Node3 prev = null;
        Node3 current = head;
        Node3 next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public Node3 getIntersectionNode(Node3 headA, Node3 headB) {
        if(headA == null || headB == null) return null;
        Node3 a = headA;
        Node3 b = headB;

        while( a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }
    public void intersection(Linkedlist l1,Linkedlist l2){
        ArrayList<Integer> al1=new ArrayList<>();
        ArrayList<Integer> al2=new ArrayList<>();
        Node3 t1=l1.head;
        while(t1!=null){
            al1.add(t1.data);
            t1=t1.next;
        }
        Node3 t2=l2.head;
        while(t2!=null){
            al2.add(t2.data);
            t2=t2.next;
        }
        al1.retainAll(al2);
        System.out.println(al1);
    }
     void printList(Node3 temp) {
        while(temp!= null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }
    void middle(Node3 temp){
        Node3 t1=temp;
        int c=0,co=0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        int m=c/2+1;
        while(t1!=null){
            co++;
            if(co==m){
                System.out.println(t1.data);
                break;
            }
            t1=t1.next;
        }

    }
    void middleContinue(Node3 temp){
        Node3 t1=temp;
        int c=0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        int m=c/2+1;
        while(t1!=null){
            m--;
            if(m==0)
                break;
            t1=t1.next;
        }
        while(t1!=null){
            System.out.print(t1.data+" ");
            t1=t1.next;
        }
//        printList(t1);

    }
//    public void middle(Node3 head) {
//        if (head == null) {
//            System.out.println("The list is empty.");
//            return;
//        }
//
//        Node3 slow = head;
//        Node3 fast = head;
//
//        // Move fast pointer two steps ahead and slow pointer one step ahead
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        // At this point, the slow pointer will be at the middle node
//        System.out.println("The middle element is: " + slow.data);
//    }
    //    public void deleteAt(int v) {
//        Node3 temp = head;
//        Node3 prev = null;
//        boolean found = false;
//
//        while (temp != null) {
//            if (temp.data == v) {
//                found = true;
//                if (prev != null) {
//                    prev.next = temp.next;
//                    if (temp == tail) {
//                        tail = prev;
//                    }
//                } else {
//                    head = temp.next;
//                    if (head == null) {
//                        tail = null;
//                    }
//                }
//                break;
//            }
//            prev = temp;
//            temp = temp.next;
//        }
//
//        if (!found) {
//            System.out.println(v+" Not in List");
//            return;
//        }
//        display();
//    }
//}
}
public class SingleLinkedListImplementation {
    public static void main(String[] args) {
        Linkedlist l=new Linkedlist();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.insert(6);
        Linkedlist l2=new Linkedlist();
//        l2.insert(6);
//        l2.insert(3);
//        l2.insert(8);
//        l2.insert(9);
//        l2.insert(10);
//        System.out.println("\nAfter inserting elements list 1 : ");
        l.display();
//        System.out.println("\nAfter inserting elements list 2 : ");
//        l2.display();
//        System.out.println("\nIntersection");
//        l.intersection(l,l2);
//        System.out.println(l.getIntersectionNode(l.head,l2.head));
//        l.mergeList(l2);
//        l.insertBeg(0);
//        System.out.println("\nAfter inserting Begining 0 : ");
//        l.display();
//        l.insertAt(2,9);
//        System.out.println("\nAfter inserting specific position 2 in value 9");
//        l.display();
//        l.deleteBeg();
//        System.out.println("\nAfter delete begining : ");
//        l.display();
//        l.deleteEnd();
//        System.out.println("\nAfter delete End : ");
        System.out.println();
        Node3 r=l.rotateRight(2);
        System.out.println();
        l.printList(r);
//        l.deleteAt(1);
//        System.out.println("\nAfter delete Specific 1 : ");
//        l.display();
//        System.out.println("\nDisplay Reverse : ");
//        l.displayReverse(l.head);
//        System.out.println();
//        l.reverseList();
//        l.display();
        System.out.println();
        l.middleContinue(l.head);
//        l.middle(l.head);
    }
}