import java.util.*;
public class SortingInsertion{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int k=0,v=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(a[j]+" ");
            System.out.println();
            k=a[i];
            v=i-1;
            while(v>=0 && a[v]>k){
                a[v+1]=a[v];
                v=v-1;
            }
            a[v+1]=k;
        }
        for(int j=0;j<n;j++)
            System.out.print(a[j]+" ");
    }
}