import java.util.Scanner;

class Main {
	final static int INF = 999 ;
	static int V ;
	static void floydWarshall(int graph[][])
	{
		int dist[][] = new int[V][V];
		int i, j, k;
		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];		
		for (k = 0; k < V; k++) {
			for (i = 0; i < V; i++) {
				for (j = 0; j < V; j++) {
					if (dist[i][k] + dist[k][j]
						< dist[i][j])
						dist[i][j]
							= dist[i][k] + dist[k][j];
				}
			}
		}

		printSolution(dist);
	}

	static void printSolution(int dist[][])
	{
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ") ;
				else
					System.out.print(dist[i][j] + " ") ;
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
	    
	    Scanner sc = new Scanner(System.in) ;
	    
	    V = sc.nextInt() ;
	    
	    int edges = sc.nextInt() ;
	    
	    int graph[][] = new int [V][V] ;
	    
	    for(int i = 0 ; i < V ; i++){
	        for(int j = 0 ; j < V ; j++){
	            if(i==j)
	                graph[i][j] = 0 ;
	            else
	                graph[i][j] = INF ;
	        }
	    }
	    
	    int start, end, value ;
	    
	    for(int i = 0 ; i < edges ; i++){
	        start = sc.nextInt() ;
	        end = sc.nextInt() ;
	        value = sc.nextInt() ;
	        
	        graph[start][end] = value ;
	        graph[end][start] = value ;
	    }
	    System.out.println("Original matrix") ;
	    for(int i = 0 ; i < V ; i++){
	        for(int j = 0 ; j < V ; j++){
	            if(graph[i][j] == INF)
	                System.out.print("INF ") ;
	            else
	                System.out.print(graph[i][j]+" ") ;
	        }
	        System.out.println() ;
	    }
	    System.out.println() ;
	    
	    System.out.println("Shortest path matrix") ;
	    
	    floydWarshall(graph);
	}
}
