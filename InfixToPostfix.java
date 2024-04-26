import java.util.*;

public class InfixToPostfix {
    static int prec(char x)
    {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char c[]=sc.next().toCharArray();
        Stack<Character> op=new Stack<>();
        char sympol;
        String postfix="";
        for(int i=0;i<c.length;i++){
            sympol=c[i];
            if(Character.isLetter(c[i]))
                postfix=postfix+c[i];
            else if(c[i]=='(')
                op.push(c[i]);
            else if(c[i]==')'){
                while(op.peek()!='('){
                    postfix=postfix+op.pop();
                }
                op.pop();
            }
            else{
                while (!op.isEmpty()  && prec(sympol) <= prec(op.peek())){
                        postfix = postfix + op.pop();
                    }
                        op.push(sympol);
            }
        }
            while (!op.isEmpty()) {
                postfix = postfix + op.pop();
            }
        System.out.println(postfix);
    }
}
