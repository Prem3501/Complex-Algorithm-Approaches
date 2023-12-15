import java.util.Scanner;

class Main {
    public static int calculateProduct(int[] A, int L, int R, int P) {
        L = L - 1;
        R = R - 1;
        int ans = 1;
        for (int i = L; i <= R; i++) {
            ans = ans * A[i];
            ans = ans % P;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int P = scanner.nextInt();
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        System.out.println(calculateProduct(a, L, R, P));
    }
}

