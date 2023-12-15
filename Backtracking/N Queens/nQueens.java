import java.util.Scanner;

public class nQueens  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        solveNQ(N);
    }

    static void printsolution(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }

    static boolean issafe(int[][] board, int n, int row, int col) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = col; j >= 0 && i < n; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean solveNQUtil(int[][] board, int n, int col) {
        if (col >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (issafe(board, n, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, n, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    static void solveNQ(int n) {
        int[][] board = new int[n][n];
        if (solveNQUtil(board, n, 0)) {
            printsolution(board, n);
        }
    }
}