import java.util.Scanner;
import java.util.Arrays;
class Main {
	static int compute_Levenshtein_distanceDP(String str1, String str2)
	{
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++)
		{
			for (int j = 0; j <= str2.length(); j++) {

				if (i == 0) {
					dp[i][j] = j;
				}

				else if (j == 0) {
					dp[i][j] = i;
				}

				else {
					dp[i][j] = minm_edits(dp[i - 1][j - 1]
						+ NumOfReplacement(str1.charAt(i - 1),str2.charAt(j - 1)), // replace
						dp[i - 1][j] + 1, // delete
						dp[i][j - 1] + 1); // insert
				}
			}
		}

		return dp[str1.length()][str2.length()];
	}
	static int NumOfReplacement(char c1, char c2)
	{
		return c1 == c2 ? 0 : 1;
	}
	static int minm_edits(int... nums)
	{

		return Arrays.stream(nums).min().orElse(
			Integer.MAX_VALUE);
	}
	public static void main(String args[])
	{
	    Scanner sc = new Scanner(System.in) ;
		String s1 = sc.next() ;
		String s2 = sc.next() ;

		System.out.println(compute_Levenshtein_distanceDP(s1, s2));
	}
}
