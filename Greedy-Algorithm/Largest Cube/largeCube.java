import java.util.*;
class Main
{
	static Vector<String> preProcess(int n)
	{
		Vector<String> preProcessedCubes = new Vector<>();
		for (int i = 1; i * i * i <= n; i++)
		{
			int iThCube = i * i * i;
			String cubeString = String.valueOf(iThCube);
			preProcessedCubes.add(cubeString);
		}
		return preProcessedCubes;
	}
	static String findLargestCubeUtil(String num,
			Vector<String> preProcessedCubes)
	{
		Collections.reverse(preProcessedCubes);

		int totalCubes = preProcessedCubes.size();
		for (int i = 0; i < totalCubes; i++)
		{
			String currCube = preProcessedCubes.get(i);

			int digitsInCube = currCube.length();
			int index = 0;
			int digitsInNumber = num.length();
			for (int j = 0; j < digitsInNumber; j++)
			{

				if (num.charAt(j) == currCube.charAt(index))
				{
					index++;
				}

				if (digitsInCube == index)
				{
					return currCube;
				}
			}
		}
		return "Not Possible";
	}
	static void findLargestCube(int n)
	{
		Vector<String> preProcessedCubes = preProcess(n);
		String num = String.valueOf(n);

		String ans = findLargestCubeUtil(num, preProcessedCubes);

		System.out.println("Largest Cube that can be formed from "
				+ n + " is " + ans);
	}
	public static void main(String[] args)
	{
	  Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		findLargestCube(n);
	}
}