package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = 300;
        int max = 0;
        int tmp;
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if (tmp < min)
                    min = tmp;
                if (tmp > max)
                    max = tmp;
            }
        }

        int[] result = new int[257];

        for (int i = min; i <= max; i++) {
            tmp = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] < i) {
                        result[i] += i - map[j][k];
                        tmp -= i - map[j][k];
                    } else if (map[j][k] > i) {
                        result[i] += 2 * (map[j][k] - i);
                        tmp += map[j][k] - i;
                    }
                }
            }
            if (tmp < 0)
                result[i] = 0;
        }

        min = 300;
        int height = 0;

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                if (result[i] <= min) {
                    min = result[i];
                    height = i;
                }
            }
        }
        if (min == 300) {
            System.out.println(map[0][0] + " " + 0);
        }else{
            System.out.println(min + " " + height);

        }


    }
}
