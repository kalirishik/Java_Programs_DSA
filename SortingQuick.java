import java.util.*;
public class SortingQuick{
    public static void quickSort(int a[],int lp,int up){
        if(lp<up){
            int loc=partition(a,lp,up);
            quickSort(a,lp,loc-1);
            quickSort(a,loc+1,up);
        }
    }
    public static void display(int a[]){
        System.out.print("[");
        for(int i=0;i<a.length;i++){
            if(i!=a.length-1)System.out.print(a[i]+", ");
            else System.out.print(a[i]);
        }
        System.out.print("]\n");
    }
    public static int partition(int a[],int lp,int up){
        int pivot=a[lp];
        int start=lp+1;
        int end=up;
        while(start<=end){
            while(start <=end &&  a[start]<=pivot){
                start++;
            }
            while(a[end]>pivot){
                end--;
            }
            if(start<=end){
                int t=a[start];
                a[start]=a[end];
                a[end]=t;
            }
        }
        int te=a[lp];
        a[lp]=a[end];
        a[end]=te;
        display(a);
        return end;

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        quickSort(a,0,n-1);
    }
}