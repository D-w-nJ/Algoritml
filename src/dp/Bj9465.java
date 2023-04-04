package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int k = 0; k < 2; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }
            if(N==1){
                sb.append(Math.max(arr[0][0],arr[0][1])).append("\n");
                continue;
            }
            arr[1][0] = arr[0][1] + arr[1][0];
            arr[1][1] = arr[0][0] + arr[1][1];
            for (int j = 2; j < N; j++) {
                arr[j][0] += Math.max(arr[j - 1][1], arr[j - 2][1]);
                arr[j][1] += Math.max(arr[j - 1][0], arr[j - 2][0]);
            }
            sb.append(Math.max(arr[N - 1][1], arr[N - 1][0])).append("\n");
        }

        System.out.println(sb);
    }
}
