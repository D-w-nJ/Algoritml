package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] pan = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if(line.charAt(j)=='W')
                    pan[i][j] = true;
            }
        }

        boolean flag = true;

        int min = 64;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int tmp = 0;
                for (int z = i; z < i + 8; z++) {
                    for (int k = j; k < j + 8; k++) {
                        if (pan[z][k] == flag) {
                            tmp++;
                        }
                        flag = !flag;
                    }
                    flag = !flag;
                }
                tmp = Math.min(tmp,64-tmp);
                if(tmp<min)
                    min = tmp;
            }
        }

        System.out.println(min);
    }
}
