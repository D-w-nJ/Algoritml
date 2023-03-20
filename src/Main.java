import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, "", M);
        System.out.println(sb);
    }

    static void dfs(int start, String pre, int num) {
        if (num == 0) {
            sb.append(pre).append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            String tmp = pre + arr[i] + " ";
            dfs(i, tmp, num - 1);
        }
    }
}
