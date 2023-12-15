import java.util.Scanner;

public class dogMaze {
    static boolean isSafe(int r, int c, int n, int[][] maze) {
        if (r < 0 || r >= n)
            return false;
        if (c < 0 || c >= n)
            return false;
        if (maze[r][c] == 1)
            return true;
        return false;
    }

    static boolean solvemaze(int[][] maze, int i, int j, int[][] soln, int n) {
        if (i == n - 1 && j == n - 1) {
            soln[i][j] = 1;
            return true;
        }
        if (isSafe(i, j, n, maze)) {
            soln[i][j] = 1;
            if (solvemaze(maze, i + 1, j, soln, n))
                return true;
            if (solvemaze(maze, i, j + 1, soln, n))
                return true;
            soln[i][j] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] maze = new int[n][n];
        int[][] soln = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scanner.nextInt();
                soln[i][j] = 0;
            }
        }
        if (solvemaze(maze, 0, 0, soln, n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(soln[i][j] + " ");
                System.out.println();
            }
        } else {
            System.out.println("-1");
        }
    }
}