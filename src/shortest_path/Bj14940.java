package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj14940 {
    static int[][] graph;
    static boolean[][] map;
    static int n, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -1);
        }

        int targetX = -1;
        int targetY = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) {
                    targetX = i;
                    targetY = j;
                    graph[i][j] = 0;
                } else if (tmp == 1) {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                    graph[i][j] = 0;
                }
            }
        }

        bfs(targetX, targetY);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int targetX, int targetY) {
        int[] xOrder = new int[]{0, 0, 1, -1};
        int[] yOrder = new int[]{1, -1, 0, 0};

        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{targetX, targetY});

        while (!q.isEmpty()) {
            int[] tmpQueue = q.poll();
            map[tmpQueue[0]][tmpQueue[1]] = false;
            for (int i = 0; i < 4; i++) {
                int tmpX = tmpQueue[0] + xOrder[i];
                int tmpY = tmpQueue[1] + yOrder[i];

                if (tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= m || !map[tmpX][tmpY]) {
                    continue;
                }
                q.offer(new int[]{tmpX, tmpY});
                graph[tmpX][tmpY] = graph[tmpQueue[0]][tmpQueue[1]] + 1;
                map[tmpX][tmpY] = false;
            }
        }
    }
}
