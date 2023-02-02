package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = 100000000;
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int remin = 100000000;
                for (int k = 0; k < 3; k++) {
                    if (k == j)
                        continue;
                    remin = Math.min(arr[i][j] + arr[i - 1][k], remin);
                }
                arr[i][j] = remin;
                if (i == N - 1) {
                    if (min > arr[i][j])
                        min = arr[i][j];
                }
            }
        }
        System.out.println(min);

    }
}
