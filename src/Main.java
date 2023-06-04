import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int numWidth = W / (M + 1) + 1;
        if (W % (M + 1) == 0) {
            numWidth -= 1;
        }

        int numLength = H / (N + 1) + 1;
        if (H % (N + 1) == 0) {
            numLength -= 1;
        }

        System.out.println(numWidth * numLength);
    }

}