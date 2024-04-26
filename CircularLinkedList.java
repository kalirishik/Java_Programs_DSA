import java.util.Scanner;
class Node6{
    int val;
    Node6 next;
    Node6(int val){
        this.val=val;
    }
}
class CLL{
    Node6 head,tail;
    void insert(int val){
        Node6 n=new Node6(val);
        if(head==null){
            head=n;
            tail=n;
            return;
        }
        tail.next=n;
        n.next=head;
        tail=n;
    }
    void display(){
        Node6 temp=head;
        if(head!=null){
            do{
                System.out.print(temp.val+"->");
                temp=temp.next;
            }while(temp!=head);
            System.out.println("HEAD");
        }
    }
    void delete(int val){
        Node6 n=head;
        if(n==null)
            return;
        if(n.val==val){
            head=head.next;
            tail.next=head;
            return;
        }
        do{
            Node6 node=n.next;
            if(node.val==val){
                n.next=node.next;
                break;
            }
            node=node.next;
        }while(n!=head);
    }
}
public class CircularLinkedList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CLL c=new CLL();
        c.insert(2);
        c.insert(3);
        c.insert(4);
        c.display();
        c.delete(3);
        c.display();
    }
}
