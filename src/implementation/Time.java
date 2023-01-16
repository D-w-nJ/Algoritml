package implementation;

import java.io.IOException;
import java.util.Scanner;

public class Time {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 3,13,23,30~39,43,53 분의 경우 60초 전부 -> 15*60
        // 아닌경우 3,13,23,30~39,43,53초, 45*15

        int result = 0;
        int m = 60, s = 60;
        for (int i = 0; i <= n; i++) {
            if ((i == 3) || (i == 13) || (i == 23)) {
                result += m * s;
            } else {
                result += 15 * 60 + 45 * 15;
            }
        }
        System.out.println(result);
    }
}
