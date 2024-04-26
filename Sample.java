import java.util.Scanner;
public class Sample {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int sum=0,max=0;
        for(int i=0;i<s.length();i++){
            sum=Integer.parseInt(s.charAt(i)+"");
            max=Math.max(sum,max);
        }
        System.out.println(max);
    }
}
