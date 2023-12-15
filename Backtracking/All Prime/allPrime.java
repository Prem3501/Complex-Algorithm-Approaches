import java.util.ArrayList;
import java.util.List;

public class allPrime {
    boolean isPrimeNumber(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    void printPrimes() {
        for (int i = 0; i < primeNo.size(); i++) {
            System.out.print(primeNo.get(i) + "\t");
        }
        System.out.println();
    }

    void GeneratePrimeSum(int total, int N, int S, int index) {
        if (total == S && set.size() == N) {
            printPrimes();
            return;
        }
        if (total > S || index == primeNo.size()) {
            return;
        }
        set.add(primeNo.get(index));
        GeneratePrimeSum(total + primeNo.get(index), N, S, index + 1);
        set.remove(primeNo.get(index));
        GeneratePrimeSum(total, N, S, index + 1);
    }

    public static void main(String[] args) {
        PrimeSum primeSum = new PrimeSum();
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int N = sc.nextInt();
        int P = sc.nextInt();
        primeSum.primeNo = new ArrayList<>();
        for (int i = P + 1; i <= S; i++) {
            if (primeSum.isPrimeNumber(i)) {
                primeSum.primeNo.add(i);
            }
        }
        if (primeSum.primeNo.size() < N) {
            return;
        }
        primeSum.GeneratePrimeSum(0, N, S, 0);
    }
}