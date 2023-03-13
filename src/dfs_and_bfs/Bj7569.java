package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj7569 {
    static int[][][] map;
    static Queue<Node> q = new LinkedList<>();
    static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boolean flag = false;

        map = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 0) flag = true;
                    if (map[i][j][k] == 1) {
                        q.offer(new Node(k, j, i));
                    }
                }
            }
        }
        if (!flag) {
            System.out.println(0);
            return;
        }
        bfs();
        int max = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (max < map[i][j][k])
                        max = map[i][j][k];
                }
            }
        }

        System.out.println(max-1);
    }

    static void bfs() {
        int[] dx = new int[]{-1, 1, 0, 0, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1, 0, 0};
        int[] dz = new int[]{0, 0, 0, 0, 1, -1};
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 6; i++) {
                int x = node.getX() + dx[i];
                int y = node.getY() + dy[i];
                int z = node.getZ() + dz[i];
                if (x < 0 || y < 0 || z < 0 || x >= M || y >= N || z >= H) {
                    continue;
                }
                if (map[z][y][x] == 0) {
                    map[z][y][x] = map[node.getZ()][node.getY()][node.getX()] + 1;
                    q.offer(new Node(x, y, z));
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int z;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
