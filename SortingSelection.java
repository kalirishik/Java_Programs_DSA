import java.util.*;
public class SortingSelection{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min])
                    min=j;
            }
            if(min!=i){
                int t=a[i];
                a[i]=a[min];
                a[min]=t;
            }
            for(int j=0;j<n;j++)
                System.out.print(a[j]+" ");
            System.out.println();
        }
        for(int j=0;j<n;j++)
            System.out.print(a[j]+" ");
    }
}