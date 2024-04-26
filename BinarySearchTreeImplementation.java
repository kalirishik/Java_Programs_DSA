import java.util.LinkedList;
import java.util.Queue;

class Node2{
    Node2 left;
    Node2 right;
    int data;
    public Node2(int data){
        this.data=data;
    }
}
class BinarySearchTree{
    public static Node2 insert(Node2 root,int val){
        if(root==null){
            root=new Node2(val);
        }
        else if(root.data>val){
            root.left=insert(root.left,val);
        }
        else if(root.data<val){
            root.right=insert(root.right,val);
        }
        return root;

    }
    public static void inorder(Node2 root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(Node2 root){
        if(root==null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void preorder(Node2 root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        inorder(root.left);
        inorder(root.right);
    }
    public static  boolean search(Node2 root,int val){
        if(root==null)
            return false;
        if(root.data==val)
            return true;
        else if(root.data<val)
            search(root.right,val);
        else if(root.data>val)
            search(root.left,val);
        return false;
    }
    public static void levelorder(Node2 root){
        Queue<Node2> q1=new LinkedList<>();
        q1.add(root);
        q1.add(null);
        while(!q1.isEmpty()){
            Node2 cur=q1.remove();
            if(cur==null){
                System.out.println();
                if(q1.isEmpty()){
                    break;
                }
                else{
                    q1.add(null);
                }
            }
            else{
                System.out.print(cur.data+" ");
                if(cur.left!=null)
                    q1.add(cur.left);
                if(cur.right!=null)
                    q1.add(cur.right);
            }
        }
    }
public static int numberofnodes(Node2 root){
    if(root==null)
        return 0;
    int left=numberofnodes(root.left);
    int right=numberofnodes(root.right);
    return left+right+1;
    }
    public static int sumofnodes(Node2 root){
        if(root==null)
            return 0;
        int left=sumofnodes(root.left);
        int right=sumofnodes(root.right);
        return left+right+root.data;
    }
    public static int heightoftree(Node2 root){
        if(root==null)
            return 0;
        int left=heightoftree(root.left);
        int right=heightoftree(root.right);
        return Math.max(left,right);
    }
//    public static int findMin(Node2 root){
//        if(root==null)
//            System.out.println("No tree exists");
//        else if(root.left==null)
//            return root.data;
//        return findMin(root.left);
//    }
    public static int findmin(Node2 root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    public static Node2 deleteNode(Node2 root,int v){
        if(root==null)
            System.out.println("No tree exists");
        if(root.data>v)
            root.left=deleteNode(root.left,v);
        else if(root.data<v)
            root.right=deleteNode(root.right,v);
        else{
            if(root.right==null)
                return root.left;
            if(root.left==null)
                return root.right;
            root.data=findmin(root.right);
            root.right=deleteNode(root.right,root.data);
        }
        return root;
    }
}
public class BinarySearchTreeImplementation{
    public static void main(String[] args) {
        Node2 n=null;
        int a[]={5,4,2,3,1,6,7};
        for(int i=0;i<a.length;i++)
            n=BinarySearchTree.insert(n,a[i]);
        System.out.print("Inorder   : ");
        BinarySearchTree.inorder(n);
        System.out.print("\nPostorder : ");
        BinarySearchTree.postorder(n);
        System.out.print("\nPreorder  : ");
        BinarySearchTree.preorder(n);
        System.out.println();
        BinarySearchTree.levelorder(n);
        System.out.println(BinarySearchTree.search(n,4));
        System.out.println("Number of nodes : "+BinarySearchTree.numberofnodes(n));
        System.out.println("Sum of nodes : "+BinarySearchTree.sumofnodes(n));
        BinarySearchTree.deleteNode(n,5);
        BinarySearchTree.levelorder(n);
        System.out.print("Inorder   : ");
        BinarySearchTree.inorder(n);
    }
}