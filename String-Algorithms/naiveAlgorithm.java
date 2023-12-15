import java.util.Scanner ;

class Main 
{
	static void search(String pat, String txt)
	{
		int l1 = pat.length();
		int l2 = txt.length();
		int i = 0, j = l2 - 1;

		for (i = 0, j = l2 - 1; j < l1;) {

			if (txt.equals(pat.substring(i, j + 1))) {
				System.out.println("Found at " + i);
				System.exit(0) ;
			}
			i++;
			j++;
		}
		System.out.print("Not Found") ;
	}
	
	public static void main(String args[])
	{
	    Scanner sc = new Scanner(System.in) ;
	    
		String pat = sc.next() ;
		String txt = sc.next() ;

		search(pat, txt) ;
	}
}