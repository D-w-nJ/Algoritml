package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9461 {
    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;
        arr[4] = 2L;
        arr[5] = 2L;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sb.append(func(tmp) + "\n");
        }
        System.out.println(sb);
    }

    static long func(int N) {
        if (arr[N] != 0)
            return arr[N];
        else {
            arr[N] = func(N - 1) + func(N - 5);
            return arr[N];
        }
    }
}
