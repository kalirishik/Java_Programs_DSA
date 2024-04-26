import java.util.Scanner;
public class SearchingLinear {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
        int f=sc.nextInt();
        for(int i=0;i<n;i++){
            if(a[i]==f){
                System.out.println("Element "+f+" is found at "+i);
                return;
            }
        }
        System.out.println("Element not found");
    }
}
