import java.util.Scanner;
class StackDemo{
    int top=-1;
    int a[]=new int[5];
    void push(int data){
        top++;
        if(top==a.length-1)
            System.out.println("Stack is full");
        else
            a[top]=data;
    }
    void pop(){
        if(top<=-1)
            System.out.println("Stack is empty");
        else{
            System.out.println("popped element is "+a[top]);
            top--;
        }
    }
    void peek(){
        if(top<=-1)
            System.out.println("Stack is empty");
        else
            System.out.println("peek element is "+a[top]);
    }
    void display(){
        if(top<=-1)
            System.out.println("Stack is empty");
        else {
            for (int i = top; i >= 0; i--)
                System.out.println(a[i]);
        }
    }

}
public class StackImplementation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StackDemo s=new StackDemo();
        s.push(25);
        s.push(30);
        s.push(35);
        s.push(35);
        s.push(35);
        s.peek();
        s.pop();
        s.display();
    }
}
