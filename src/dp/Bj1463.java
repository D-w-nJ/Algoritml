package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1463 {
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        value = new int[N + 1];

        func(N);
        System.out.println(value[N]);
    }

    static int func(int N) {
        int tmp;
        if (N == 1) {
            return 0;
        } else if (value[N] != 0) {
            return value[N];
        } else if (N % 3 == 0 && N % 2 == 0) {
            tmp = Math.min(func(N / 3), func(N / 2));
            value[N] = Math.min(tmp, func(N - 1)) + 1;
            return value[N];
        } else if (N % 2 == 0 && N % 3 == 1) {
            value[N] = Math.min(func(N - 1), func(N / 2)) + 1;
            return value[N];
        } else if (N % 2 == 0) {
            value[N] = Math.min(func(N - 1), func(N / 2)) + 1;
            return value[N];
        } else if (N % 3 == 0) {
            value[N] = Math.min(func(N - 1), func(N / 3)) + 1;
            return value[N];
        } else {
            value[N] = func(N - 1) + 1;
            return value[N];
        }
    }
}
