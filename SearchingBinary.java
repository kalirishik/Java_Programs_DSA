import java.util.Scanner;

public class SearchingBinary {
    static int generate(int a[],int lp,int up,int t){
        if(lp>up)
            return -1;
        int mid=(lp+up)/2;
        if(a[mid]==t)
            return mid;
        else if(a[mid]<t)
            return generate(a,mid+1,up,t);
        return generate(a,lp,mid-1,t);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
//        int a[]={23,41,56,89,75,11};
        int f=sc.nextInt();
        System.out.println(generate(a,0,a.length-1,f));
//        int lp=0,up=n-1,c=0,v=0;
//        while(lp<=up){
//            int mid=(lp+up)/2;
//            if(a[mid]==f){
//                v=mid;
//                c++;
//                break;
//            }
//            else if(a[mid]<f){
//                lp=mid+1;
//                c++;
//            }
//            else{
//                up=mid-1;
//                c++;
//            }
//        }
//        System.out.println("Element "+f+" found at "+v);
//        System.out.println(c+" comparisons");
    }
}
