import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }
}
class BinaryTree{
    Node root;
//    BinaryTree(int data){
//        root=new Node(data);
//    }
//    public  void insertLeft(Node root,int data){
//        root.left=new Node(data);
//    }
//    public void insertRight(Node root,int data){
//        root.right=new Node(data);
//    }
    static  int index=-1;
    public static Node btree(int a[]){
        index++;
        if(a[index]==-1)
            return null;
        Node root=new Node(a[index]);
        root.left=btree(a);
        root.right=btree(a);
        return root;
    }
    public void inOrder(Node root){
        if(root == null)
            return;
        else{
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    public void preOrder(Node root){
        if(root == null)
            return;
        else{
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(Node root){
        if(root == null)
            return;
        else{
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
    public static void levelorder(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node n=q.poll();
            if(n==null){
                System.out.println();
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                System.out.print(n.data+" ");
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
        }

    }
}
public class BinaryTreeImplementation {
    public static void main(String[] args) {
    BinaryTree bt =new BinaryTree();
    int a[]={1,2,4,-1,-1,-1,3,5,-1,-1,6,-1,-1};
    Node root=BinaryTree.btree(a);
//    bt.insertLeft(bt.root,2);
//    bt.insertRight(bt.root,3);
//    bt.insertLeft(bt.root.left,4);
//    bt.insertRight(bt.root.left,5);
    System.out.println("----- Binary Tree -----");
    System.out.print("Inorder   : ");
    bt.inOrder(root);
    System.out.print("\nPreorder  : ");
    bt.preOrder(root);
    System.out.print("\nPostorder : ");
    bt.postOrder(root);
    System.out.println("\nLevel order");
    bt.levelorder(root);
    System.out.println("\n-----------------------");
    }
}
