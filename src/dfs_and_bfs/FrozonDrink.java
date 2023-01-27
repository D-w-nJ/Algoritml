package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FrozonDrink {
    public static int width, height;
    public static int[][] map = new int[1000][1000];

    public static boolean dfs(int x, int y) {
        if ((x < 0) || (x >= width) || (y < 0) || (y >= height))
            return false;
        if (map[x][y] == 0) {
            map[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        StringTokenizer st = new StringTokenizer(line1);
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        for (int i = 0; i < width; i++) {
            String line = br.readLine();
            StringTokenizer stl = new StringTokenizer(line);
            for (int j = 0; j < height; j++) {
                map[i][j] = Integer.parseInt(stl.nextToken());
            }
        }
        int result = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (dfs(i, j)) result++;
            }
        }
        System.out.println(result);
    }
}
