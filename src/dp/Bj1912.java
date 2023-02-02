package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1912 {
    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max = arr[0];
        dp = new Integer[N];
        dp[0] = arr[0];

        func(N-1);

        System.out.println(max);

    }

    static int func(int N) {
        if (dp[N] != null)
            return dp[N];
        else {
            dp[N] = Math.max(func(N - 1) + arr[N], arr[N]);
            max = Math.max(dp[N], max);
        }
        return dp[N];
    }
}
