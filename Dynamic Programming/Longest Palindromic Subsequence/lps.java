import java.util.Scanner;
class Main {
	static int max(int x, int y) { return (x > y) ? x : y; }
	static int lps(String seq, int i, int j, int dp[][])
	{
		if (i == j) {
			return dp[i][j] = 1;
		}
		if (seq.charAt(i) == seq.charAt(j) && i + 1 == j) {
			return dp[i][j] = 2;
		}
		if(dp[i][j] != -1){
		return dp[i][j];
		}
		if (seq.charAt(i) == seq.charAt(j)) {
			return dp[i][j] = lps(seq, i + 1, j - 1, dp) + 2;
		}
		return dp[i][j] = max(lps(seq, i, j - 1, dp), lps(seq, i + 1, j, dp));
	}

	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in) ;
		String seq = sc.next() ;
		int n = seq.length();
		int dp[][] = new int[n][n];
		for(int i = 0 ; i < n ; i++){
		    for(int j = 0 ; j < n ; j++)
		        dp[i][j] = -1 ;
		}
		System.out.print(lps(seq, 0, n - 1, dp));
	}
}
