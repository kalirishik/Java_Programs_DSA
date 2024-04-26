import java.util.ArrayList;
import java.util.Scanner;
public class LongCommonSequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char c1[]=sc.next().toCharArray();
        char c2[]=sc.next().toCharArray();
        ArrayList<Character> al=new ArrayList<>();
        ArrayList<Character> bl=new ArrayList<>();
        for(int i=0;i<c1.length;i++)
            al.add(c1[i]);
        for(int i=0;i<c2.length;i++)
            bl.add(c2[i]);
        al.retainAll(bl);
        System.out.println(al);
        bl.retainAll(al);
        System.out.println(bl);
        int c=0,j=0;
        for(int i=0;i<al.size();i++){
            if(bl.get(j)==al.get(i)){
                c++;j++;
            }
        }
        System.out.println("Length of LCS is "+c);

    }
}
