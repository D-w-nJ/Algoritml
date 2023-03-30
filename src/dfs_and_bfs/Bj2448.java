package dfs_and_bfs;

import java.util.Scanner;

public class Bj2448 {
    static boolean[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        map = new boolean[num][num * 2 - 1];

        int tmp = 1;
        for (int i = 0; i < num; i++) {
            for (int j = -tmp / 2 - 1; j < tmp / 2; j++) {
                map[i][num + j] = true;
            }
            tmp += 2;
        }

        dfs(num, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num * 2 - 1; j++) {
                if (map[i][j])
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int N, int x, int y) {
        if (N == 3) {
            map[x + 1][y + 2] = false;
        } else {
            int tmp = N / 2 - 1;
            for (int i = N / 2; i < N; i++) {
                for (int j = N - tmp - 1; j < N + tmp; j++) {
                    map[x + i][y + j] = false;
                }
                tmp -= 1;
            }
            dfs(N / 2, x + N / 2, y);
            dfs(N / 2, x + N / 2, y + N);
            dfs(N / 2, x, y + N / 2);
        }

    }
}
