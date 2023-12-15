import java.util.*;
class Main 
{
	static int lookup[][] = new int[500][500];
	static void buildSparseTable(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			lookup[i][0] = arr[i];
		for (int j = 1; (1 << j) <= n; j++)
		{

			for (int i = 0; (i + (1 << j) - 1) < n; i++) 
			{

				if (lookup[i][j - 1] < lookup[i + (1 << (j - 1))][j - 1])
					lookup[i][j] = lookup[i][j - 1];
				else
					lookup[i][j] = lookup[i + (1 << (j - 1))][j - 1];
			}
		}
	}
	static int query(int L, int R)
	{
		int j = (int)Math.log(R - L + 1);
		if (lookup[L][j] <= lookup[R - (1 << j) + 1][j])
			return lookup[L][j];

		else
			return lookup[R - (1 << j) + 1][j];
	}
	public static void main(String args[])
	{
	    int i,n,s1,e1;
	    Scanner sc = new Scanner(System.in);
	    n = sc.nextInt();
	    int a[] = new int[n];
	    for(i = 0; i < n;i++)
	    a[i] = sc.nextInt();
		buildSparseTable(a, n);
        s1 = sc.nextInt();
        e1 = sc.nextInt();
		System.out.println(query(s1, e1));
	}
}
