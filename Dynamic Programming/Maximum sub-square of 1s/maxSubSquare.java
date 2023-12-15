import java.util.Scanner ;

class Main {

	static int R ;
	static int C ;

	static void printMaxSubSquare(int M[][])
	{
		int S[][] = new int[2][C], Max = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < C; j++) {
				S[i][j] = 0;
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int Entrie = M[i][j];
				if (Entrie != 0) {
					if (j != 0) {
						Entrie = 1
								+ Math.min(
									S[1][j - 1],
									Math.min(S[0][j - 1],
											S[1][j]));
					}
				}
				S[0][j] = S[1][j];
				S[1][j] = Entrie;
				Max = Math.max(Max, Entrie);
			}
  	}
		for (int i = 0; i < Max; i++) {
			for (int j = 0; j < Max; j++) {
				System.out.print("1 ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in) ;
	    
	    R = sc.nextInt() ;
	    C = sc.nextInt() ;
	    
	    int M[][] = new int[R][C] ;
	    
	    for(int i = 0 ; i < R ; i++){
	        for(int j = 0 ; j < C ; j++){
	            M[i][j] = sc.nextInt() ;
	        }
	    }

		printMaxSubSquare(M);
	}
}