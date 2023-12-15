import java.util.Scanner;
import java.util.Arrays;

class Main {

	static int coinChange(int[] a, int v, int n, int[][] dp)
	{
		if (v == 0)
			return dp[n][v] = 1;
		if (n == 0)
			return 0;
		if (dp[n][v] != -1)
			return dp[n][v];
		if (a[n - 1] <= v) {
			return dp[n][v]
				= coinChange(a, v - a[n - 1], n, dp)
				+ coinChange(a, v, n - 1, dp);
		}
		else 
			return dp[n][v] = coinChange(a, v, n - 1, dp);
	}
	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt() ;
		
		int arr[] = new int[n] ;
		
		for(int i = 0 ; i < n ; i++)
		    arr[i] = sc.nextInt() ;
		
		int s = sc.nextInt();
		
		int dp[][] = new int[n + 1][s + 1] ;
		
		for (int[] row : dp)
			Arrays.fill(row, -1);
		
		int res = coinChange(arr, s, n, dp) ;
		
		System.out.println(res);
	}
}
