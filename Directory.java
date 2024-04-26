import java.util.*;
public class Directory {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().replace("cd","").trim().split("/");
        Stack<String> st=new Stack<>();
        for(int i=0;i<s.length;i++){
            if((s[i].equals("..")) && !st.isEmpty())
                st.pop();
            else
                st.push(s[i]);
        }
        System.out.println(st);
        for(int i=0;i< st.size();i++){
            if(i!= st.size()-1)
                System.out.print(st.get(i)+"/");
            else
                System.out.print(st.get(i));
        }
    }
}
