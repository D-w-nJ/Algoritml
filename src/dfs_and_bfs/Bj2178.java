package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        while (!q.isEmpty()) {
            Node n = q.poll();
            int x = n.getX();
            int y = n.getY();
            for (int i = 0; i < 4; i++) {
                int nx = n.getX() + dx[i];
                int ny = n.getY() + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0) continue;
                if(map[nx][ny]==1){
                    map[nx][ny] = map[x][y] + 1;
                    q.offer(new Node(nx,ny));
                }
            }
        }
        System.out.println(map[N-1][M-1]);

    }
}
