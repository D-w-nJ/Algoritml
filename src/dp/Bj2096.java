package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] maxArr = new int[N][3];
        int[][] minArr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            maxArr[i][0] = Integer.parseInt(st.nextToken());
            maxArr[i][1] = Integer.parseInt(st.nextToken());
            maxArr[i][2] = Integer.parseInt(st.nextToken());
            minArr[i][0] = maxArr[i][0];
            minArr[i][1] = maxArr[i][1];
            minArr[i][2] = maxArr[i][2];
        }

        for (int i = 1; i < N; i++) {
            maxArr[i][0] += Math.max(maxArr[i - 1][0], maxArr[i - 1][1]);
            maxArr[i][1] += Math.max(maxArr[i - 1][0], Math.max(maxArr[i - 1][1], maxArr[i - 1][2]));
            maxArr[i][2] += Math.max(maxArr[i - 1][1], maxArr[i - 1][2]);
        }


        for (int i = 1; i < N; i++) {
            minArr[i][0] += Math.min(minArr[i - 1][0], minArr[i - 1][1]);
            minArr[i][1] += Math.min(minArr[i - 1][0], Math.min(minArr[i - 1][1], minArr[i - 1][2]));
            minArr[i][2] += Math.min(minArr[i - 1][1], minArr[i - 1][2]);
        }

        System.out.println(Math.max(maxArr[N - 1][0], Math.max(maxArr[N - 1][1], maxArr[N - 1][2])) + " " + Math.min(minArr[N - 1][0], Math.min(minArr[N - 1][1], minArr[N - 1][2])));
    }
}
