//package dfs_and_bfs;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class Node {
//    private int x;
//    private int y;
//
//    public int getX() {
//        return this.x;
//    }
//
//    public int getY() {
//        return this.y;
//    }
//
//    public Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class MazeEscape {
//    public static int n, m;
//    public static int[][] map = new int[201][201];
//
//    public static int dx[] = {-1, 1, 0, 0};
//    public static int dy[] = {0, 0, -1, 1};
//
//    static int bfs(int x, int y) {
//        Queue<Node> q = new LinkedList<>();
//        q.offer(new Node(x, y));
//        while (!q.isEmpty()) {
//            Node node = q.poll();
//            x = node.getX();
//            y = node.getY();
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
//                if (map[nx][ny] == 0) continue;
//                if (map[nx][ny] == 1) {
//                    map[nx][ny] = map[x][y] + 1;
//                    q.offer(new Node(nx, ny));
//                }
//            }
//        }
//        return map[n - 1][m - 1];
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer stl = new StringTokenizer(br.readLine());
//            for (int j = 0; j < m; j++) {
//                map[i][j] = Integer.parseInt(stl.nextToken());
//            }
//        }
//        System.out.println(bfs(0, 0));
//    }
//}
