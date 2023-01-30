package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj24444 {
    static int[] result;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int tmp = 1;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        result[start] = tmp++;
        q.offer(start);
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int a : graph.get(i)) {
                if (!visited[a]) {
                    visited[a] = true;
                    result[a] = tmp++;
                    q.offer(a);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        result = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(R);
        for (int i = 1; i <= N; i++)
            System.out.println(result[i]);
    }
}
