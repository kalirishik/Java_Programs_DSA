import java.util.*;
public class SortingMerge{
    public static void mergeSort(int a[],int lp,int up){
        if(lp<up){
            int mid=(lp+up)/2;
            mergeSort(a,lp,mid);
            mergeSort(a,mid+1,up);
            merge(a,lp,mid,up);
        }
    }
    public static void merge(int a[],int lp,int mid,int up){
        int i=lp,j=mid+1,k=lp;
        int b[]=new int[a.length];
        while(i<=mid && j<=up){
            if(a[i]<=a[j]){
                b[k]=a[i];
                i++;
            }
            else{
                b[k]=a[j];
                j++;
            }
            k++;
        }
        if(i>mid){
            while(j<=up){
                b[k]=a[j];
                j++;k++;
            }
        }
        else {
            while(i<=mid){
                b[k]=a[i];
                i++;k++;
            }
        }
        for( k=lp;k<=up;k++)
            a[k]=b[k];
        for( k=0;k<a.length;k++)
            System.out.print(a[k]+" ");
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        mergeSort(a,0,n-1);
    }
}