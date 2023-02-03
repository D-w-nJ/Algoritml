package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N][10];
        for (int i = 0; i < 10; i++)
            arr[0][i] = 1;

        long sum = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    arr[i][0] = arr[i - 1][1] % 1000000000;
                else if (j == 9)
                    arr[i][9] = arr[i - 1][8] % 1000000000;
                else
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
            }
        }
        for (int i = 1; i < 10; i++) {
            sum += arr[N - 1][i];
        }
        System.out.println(sum % 1000000000);
    }
}

