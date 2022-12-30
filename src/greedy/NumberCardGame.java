package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCardGame {
    public static void main(String[] args) throws IOException {
        // 행렬 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        StringTokenizer st = new StringTokenizer(line1);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            st = new StringTokenizer(row);
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        // 각 행별로 가장 작은 수 찾기
        int biggest = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] > biggest) biggest = arr[i][0];
        }

        // 가장 작은 수들 중 가장 큰 수 찾기
        System.out.println(biggest);
    }
}
