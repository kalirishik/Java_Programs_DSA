import java.util.*;
class Graph{
    ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public Graph(int v){
        for(int i=0;i<v;i++){
            list.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int u,int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }
    public void display(){
        for(int i=0;i< list.size();i++){
            System.out.println("Elements in list "+i);
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public void bfs(int v){
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[list.size()];
        q.add(v);
        visited[v]=true;
        while(q.size()!=0){
            int vertex=q.remove();
            System.out.print(vertex+" ");
            for(int i=0;i<list.get(vertex).size();i++){
                int av=list.get(vertex).get(i);
                if(!visited[av]){
                    q.add(av);
                    visited[av]=true;
                }
            }
        }
    }
    public void dfs(int v){
        Stack<Integer> s=new Stack<>();
        boolean visited[]=new boolean[list.size()];
        s.add(v);
        visited[v]=true;
        while(s.size()!=0){
            int vertex=s.pop();
            System.out.print(vertex+" ");
            for(int i=0;i<list.get(vertex).size();i++){
                int av=list.get(vertex).get(i);
                if(!visited[av]){
                    s.add(av);
                    visited[av]=true;
                }
            }
        }
    }
}
public class GraphImplementation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(2,4);
        g.display();
        System.out.print("BFS : ");
        g.bfs(0);
        System.out.print("\nDFS : ");
        g.dfs(0);
    }
}
//import java.util.*;
//class Graph{
//    ArrayList<ArrayList<Integer>> list=new ArrayList<>();
//    Graph(int v){
//        for(int i=0;i<v;i++){
//            list.add(new ArrayList<>());
//        }
//    }
//    public void addEdge(int s,int e){
//        list.get(s).add(e);
//    }
//    public void dfs(int v,boolean visited[]){
//        visited[v]=true;
//        System.out.print(v+" ");
//        for(int i=0;i<list.get(v).size();i++){
//            int av=list.get(v).get(i);
//            if(!visited[av]){
//                if(list.size()> av){
//                    visited[av]=true;
//                    dfs(av,visited);
//                }
//            }
//        }
//    }
//}
//public class GraphImplementation1{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int ve=sc.nextInt();
//        Graph g=new Graph(ve);
//        int s=sc.nextInt();
//        for(int i=0;i<s;i++)
//            g.addEdge(sc.nextInt(),sc.nextInt());
//        boolean visited[]=new boolean[ve];
//        g.dfs(0,visited);
//    }
//}