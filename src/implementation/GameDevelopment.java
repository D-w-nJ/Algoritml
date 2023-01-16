package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameDevelopment {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        int[][] dirct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 1;

        while (true) {
            int turn_time = 0;
            if (map[y + dirct[dir][0]][x + dirct[dir][1]] == 0) {
                result++;
                map[y][x] = 2;
                y += dirct[dir][0];
                x += dirct[dir][1];
            } else {
                dir--;
                if (dir == -1)
                    dir = 3;
                turn_time++;
            }
            if (turn_time == 4) {
                if (map[y - dirct[dir][0]][x - dirct[dir][1]] == 1) {
                    break;
                } else {
                    y -= dirct[dir][0];
                    x -= dirct[dir][1];
                }
            }
        }
        System.out.println(result);
    }
}
