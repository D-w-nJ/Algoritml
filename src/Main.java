import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] factors = new int[n];

        for (int i = 0; i < n; i++) {
            factors[i] = scanner.nextInt();
        }

        Arrays.sort(factors);

        long result = (long) factors[0] * factors[n-1];

        System.out.println(result);
    }
}
