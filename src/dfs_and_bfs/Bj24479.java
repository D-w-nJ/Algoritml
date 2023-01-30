package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj24479 {
    static boolean[] visited;
    static int[] result;
    static int num = 1;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    static void dfs(int i){
        visited[i] = true;
        result[i] = num++;
        for (int j : arr.get(i)) {
            if (!visited[j]) {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[N+1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(arr.get(i));
        }
        dfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

}
