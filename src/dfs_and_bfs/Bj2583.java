package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj2583 {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken()) - 1;
            int rightY = Integer.parseInt(st.nextToken()) - 1;

            for (int y = leftY; y <= rightY; y++) {
                for (int x = leftX; x <= rightX; x++) {
                    map[y][x] = true;
                }
            }
        }

        ArrayList<Integer> set = new ArrayList<>();
        int tmp;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        int[] xV = new int[]{1, -1, 0, 0};
        int[] yV = new int[]{0, 0, -1, 1};

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    cnt++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    map[i][j] = true;
                    tmp = 1;
                    while (!q.isEmpty()) {
                        int[] tmpQ = q.poll();
                        int x = tmpQ[0];
                        int y = tmpQ[1];
                        for (int k = 0; k < 4; k++) {
                            int tmpX = x + xV[k];
                            int tmpY = y + yV[k];
                            if (tmpX >= M || tmpX < 0 || tmpY >= N || tmpY < 0 || map[tmpX][tmpY]) {
                                continue;
                            }
                            q.offer(new int[]{tmpX, tmpY});
                            map[tmpX][tmpY] = true;
                            tmp++;
                        }
                    }
                    set.add(tmp);
                }
            }
        }
        sb.append(cnt).append("\n");

        Collections.sort(set);

        for (int i : set) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
