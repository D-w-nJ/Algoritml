package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1904 {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new long[N + 1];

        long num = func(N);

        System.out.println(num);
    }

    static long func(int N) {
        if (arr[N] != 0)
            return arr[N];
        else if (N == 1){
            arr[N] = 1;
            return 1;
        }
        else if (N == 2) {
            arr[N] = 2;
            return 2;
        }
        else {
            arr[N] = func(N - 1) + func(N - 2);
            return arr[N]%15746;
        }
    }
}
