import java.util.Scanner ;

public class countingFreq {
	
	static int N = 100000;
	
	static int n; 
	static int []tree = new int[2 * N];
	static void build( int []arr)
	{
		for (int i = 0; i < n; i++)
			tree[n + i] = arr[i];
		for (int i = n - 1; i > 0; --i)
			tree[i] = tree[i << 1] +
					tree[i << 1 | 1];
	}
	static void updateTreeNode(int p, int value)
	{
		tree[p + n] = value;
		p = p + n;
		for (int i = p; i > 1; i >>= 1)
			tree[i >> 1] = tree[i] + tree[i^1];
	}
	static int query(int l, int r)
	{
		int res = 0;
		for (l += n, r += n; l < r;
							l >>= 1, r >>= 1)
		{
			if ((l & 1) > 0)
				res += tree[l++];
		
			if ((r & 1) > 0)
				res += tree[--r];
		}
		
		return res;
	}
	static public void main (String[] args)
	{
	    Scanner sc = new Scanner(System.in) ;
	    
	    n = sc.nextInt() ;
	    
		int []a = new int[n] ;
		
		for(int i = 0 ; i < n ; i++)
		    a[i] = sc.nextInt() ;
		build(a);
		
		int start = sc.nextInt() ;
		int end = sc.nextInt() ;
		System.out.println(query(start, end));
		
		int index = sc.nextInt() ;
		int element = sc.nextInt() ;
		updateTreeNode(index, element);
		System.out.println(query(start, end));
	}
}
