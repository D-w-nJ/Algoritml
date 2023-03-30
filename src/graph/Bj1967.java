package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1967 {
    static int max = 0;
    static int max_idx;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(root).add(new Node(to, weight));
            graph.get(to).add(new Node(root, weight));
        }
//        for (int i = 1; i <= N; i++) {
//            visited[i] = true;
//            dfs(i, 0);
//            Arrays.fill(visited, false);
//        }
        visited[N - 1] = true;
        dfs(N - 1, 0);

        visited = new boolean[N + 1];
        visited[max_idx] = true;
        dfs(max_idx, 0);

        System.out.println(max);
    }

    static void dfs(int i, int sum) {
        for (int j = 0; j < graph.get(i).size(); j++) {
            int k = graph.get(i).get(j).to;
            if (!visited[k]) {
                int tmp = sum + graph.get(i).get(j).weight;
                visited[k] = true;
                if (max < tmp) {
                    max = tmp;
                    max_idx = k;
                }
                dfs(k, tmp);
            }
        }
    }
}

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
