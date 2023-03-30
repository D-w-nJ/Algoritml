package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < K; i++) {
            arr[0]++;
            for (int j = 1; j < N; j++) {
                arr[j] += arr[j - 1];
                arr[j] %= 1000000000;
            }
        }

        System.out.println(arr[N - 1] % 1000000000);
    }
}
