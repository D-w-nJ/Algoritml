package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1260 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> q = new LinkedList<>();

    /**
     * 꼭 Boolean이 아닌 boolean으로 쓸것..
     */

    static void dfs(int i) {
        visited[i] = true;
        sb.append(i+" ");
        for (int j = 0; j < graph.get(i).size(); j++) {
            int num = graph.get(i).get(j);
            if (!visited[num])
                dfs(num);
        }
    }

    static void bfs(int start) {
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int i = q.poll();
            sb.append(i+" ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                int tmp = graph.get(i).get(j);
                if(!visited[tmp]) {
                    q.offer(tmp);
                    visited[tmp] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tmp.nextToken());
            int b = Integer.parseInt(tmp.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }
}
