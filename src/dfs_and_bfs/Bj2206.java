package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2206 {
    static int[][] map;
    static int min = 100000000;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] tmpMap = new int[N][M];
        map = new int[N][M];
        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                tmpMap[i][j] = (tmp.charAt(j) == '0') ? 0 : -1;
                if (tmpMap[i][j] == -1)
                    arr.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++)
                    map[j][k] = tmpMap[j][k];
            }
            map[arr.get(i)[0]][arr.get(i)[1]] = 0;
            map[0][0] = 1;
            bfs(0, 0);
        }

        int result = (min == 100000000) ? -1 : min;

        System.out.println(result);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int toX = tmp[0] + dx[i];
                int toY = tmp[1] + dy[i];
                if (toX < 0 || toX >= N || toY < 0 || toY >= M)
                    continue;
                if(map[toX][toY]==0){
                    map[toX][toY] = map[tmp[0]][tmp[1]] + 1;
                    q.offer(new int[]{toX, toY});
                }

            }
        }
        if (map[N - 1][M - 1] < min && map[N - 1][M - 1] != 0)
            min = map[N - 1][M - 1];
    }
}
