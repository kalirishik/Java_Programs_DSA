import java.util.Scanner;
public class Maze1 {
    static int[][] problem ;
    static int n;
    static int[][] solution;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
        solution = new int[n][n];
        problem=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                problem[i][j]=sc.nextInt();
            }
        }
        if (!solveMaze(0, 0)) {
            System.out.println("No solution exists");
            return;
        }
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean solveMaze(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            solution[x][y] = 1;
            return true;
        }
        if (isSafe(x, y)) {
            solution[x][y] = 1;
            if (solveMaze(x + 1, y) || solveMaze(x, y + 1)) {
                return true;
            }
            solution[x][y] = 0;
            return false;
        }
        return false;
    }
    public static boolean isSafe(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n && problem[x][y] == 0);
    }
}
