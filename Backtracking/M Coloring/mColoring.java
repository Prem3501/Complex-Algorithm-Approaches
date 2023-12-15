import java.util.Scanner;
class mColoringProblem
{
	final int V = 4;
	int color[];
	boolean isSafe(
		int v, int graph[][], int color[],
		int c)
	{
		for (int i = 0; i < V; i++)
			if (
				graph[v][i] == 1 && c == color[i])
				return false;
		return true;
	}
	boolean graphColoringUtil(
		int graph[][], int m,
		int color[], int v)
	{
		if (v == V)
			return true;
		for (int c = 1; c <= m; c++)
		{
			if (isSafe(v, graph, color, c))
			{
				color[v] = c;
				if (
					graphColoringUtil(
						graph, m,
						color, v + 1))
					return true;
				color[v] = 0;
			}
		}
		return false;
	}
	boolean graphColoring(int graph[][], int m)
	{
		color = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = 0;
		if (
			!graphColoringUtil(
				graph, m, color, 0))
		{
			System.out.println(
				"Solution does not exist");
			return false;
		}
		printSolution(color);
		return true;
	}
	void printSolution(int color[])
	{
		System.out.println(
			"Solution Exists:");
		for (int i = 0; i < V; i++)
			System.out.print(color[i] + " ");
		System.out.println();
	}
	public static void main(String args[])
	{
		mColoringProblem Coloring
			= new mColoringProblem();
		Scanner sc = new Scanner(System.in);
		int [][] graph = new int[4][4];
		int m,i,j;
		for(i=0;i<4;i++) {
		    for(j=0;j<4;j++) {
		        graph[i][j] = sc.nextInt();
		    }
		}
		m= sc.nextInt();
		Coloring.graphColoring(graph, m);
	}
}
