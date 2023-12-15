import java.util.Scanner;
class KnightTour {
	//static int N;
	static boolean isSafe(int x, int y, int sol[][],int N)
	{
		return (x >= 0 && x < N && y >= 0 && y < N
				&& sol[x][y] == -1);
	}
	static void printSolution(int sol[][],int N)
	{
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++)
				System.out.print(sol[x][y] + " ");
			System.out.println();
		}
	}
	static boolean solveKT(int N)
	{
		int sol[][] = new int[N][N];
		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++)
				sol[x][y] = -1;
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		sol[0][0] = 0;
		if (!solveKTUtil(0, 0, 1, sol, xMove, yMove, N)) {
			System.out.println("Solution does not exist");
			return false;
		}
		else
			printSolution(sol,N);

		return true;
	}
	static boolean solveKTUtil(int x, int y, int movei,
							int sol[][], int xMove[],
							int yMove[],int N)
	{
		int k, next_x, next_y;
		if (movei == N * N)
			return true;
		for (k = 0; k < 8; k++) {
			next_x = x + xMove[k];
			next_y = y + yMove[k];
			if (isSafe(next_x, next_y, sol,N)) {
				sol[next_x][next_y] = movei;
				if (solveKTUtil(next_x, next_y, movei + 1,
								sol, xMove, yMove,N))
					return true;
				else
					sol[next_x][next_y]
						= -1; 
			}
		}

		return false;
	}
	public static void main(String args[])
	{
	    int N;
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
		solveKT(N);
	}
}
