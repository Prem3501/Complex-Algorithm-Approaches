import java.util.Scanner;

public class policeThieves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr = scanner.next();
        int k = scanner.nextInt();
        int caught = 0;
        int n = arr.length();
        for (int i = 0; i < n; i++) {
            if (arr.charAt(i) == 'P') {
                for (int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                    if (arr.charAt(j) == 'T') {
                        arr = arr.substring(0, j) + 'C' + arr.substring(j + 1);
                        caught++;
                        break;
                    }
                }
            }
        }
        System.out.println(caught);
    }
}