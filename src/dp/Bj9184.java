package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj9184 {
    static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1)
                break;
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(")").append(" = ");
            sb.append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if (a > 20 || b > 20 || c > 20) {
            a=20;
            b=20;
            c=20;
            if (arr[a][b][c] != 0)
                return arr[a][b][c];
            arr[a][b][c] = w(20, 20, 20);
            return arr[a][b][c];
        } else if (a < b && b < c) {
            if (arr[a][b][c] != 0)
                return arr[a][b][c];
            arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return arr[a][b][c];
        } else {
            if (arr[a][b][c] != 0)
                return arr[a][b][c];
            arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b-1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            return arr[a][b][c];
        }

    }
}
