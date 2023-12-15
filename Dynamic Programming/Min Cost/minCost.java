import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[100][100];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.println(minCost(cost, n, n));
    }

    public static int minCost(int[][] cost, int endrow, int endcol) {
        for (int i = 1; i < endrow; i++)
            cost[i][0] += cost[i - 1][0];

        for (int j = 1; j < endcol; j++)
            cost[0][j] += cost[0][j - 1];

        for (int i = 1; i < endrow; i++)
            for (int j = 1; j < endcol; j++)
                cost[i][j] += Math.min(cost[i - 1][j], cost[i][j - 1]);

        return cost[endrow - 1][endcol - 1];
    }
}