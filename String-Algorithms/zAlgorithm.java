import java.util.Scanner ;

class Main 
{
	static void zAlgo(String text, String pattern)
	{
		String concat = pattern + "$" + text;
		int l = concat.length();
		int Z[] = new int[l];
		getZarr(concat, Z);		
		boolean found = false ;
		for(int i = 0; i < l; ++i){
			if(Z[i] == pattern.length()){
				System.out.println("Found at " + (i - pattern.length() - 1));
				found = true ;
			}
		}
		if(found == false)
		    System.out.print("Not Found") ;
	}
	private static void getZarr(String str, int[] Z) {
		int n = str.length();
		int L = 0, R = 0;
		for(int i = 1; i < n; ++i) {
			if(i > R){
				L = R = i;
				while(R < n && str.charAt(R - L) == str.charAt(R))
					R++;
				Z[i] = R - L;
				R--;
			}
			else{
				int k = i - L;
				if(Z[k] < R - i + 1)
					Z[i] = Z[k];
				else{
					L = i;
					while(R < n && str.charAt(R - L) == str.charAt(R))
						R++;
					
					Z[i] = R - L;
					R--;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in) ;
	    
		String text = sc.next() ;
		
		String pattern = sc.next() ;

		zAlgo(text, pattern);
	}
}
