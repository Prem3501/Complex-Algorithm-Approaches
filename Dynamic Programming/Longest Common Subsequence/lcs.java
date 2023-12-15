import java.util.Scanner ;

class Main {

	static int lcs(String X, String Y, int m, int n)
	{
		int L[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	static int max(int a, int b)
	{
		return (a > b) ? a : b;
	}

	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in) ;
	    
		String s1 = sc.next() ;
		String s2 = sc.next() ;

		int m = s1.length() ;
		int n = s2.length() ;

		System.out.println(lcs(s1, s2, m, n));
	}
}
