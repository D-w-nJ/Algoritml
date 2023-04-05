package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj1167 {
    static ArrayList<ArrayList<Apex>> graph = new ArrayList<>();
    static int[] dis;
    static int max = 0;
    static int index;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1)
                    break;
                int next = Integer.parseInt(st.nextToken());
                graph.get(num).add(new Apex(tmp, next));
            }
        }

        dis = new int[V + 1];
        Arrays.fill(dis, 1000000000);
        dfs(1);

        dis = new int[V + 1];
        Arrays.fill(dis, 1000000000);
        max = 0;
        dfs(index);

        System.out.println(max);
    }

    static void dfs(int N) {
        PriorityQueue<Apex> pq = new PriorityQueue<>();
        dis[N] = 0;
        pq.offer(new Apex(N, 0));
        while (!pq.isEmpty()) {
            Apex apex = pq.poll();
            if (dis[apex.to] < apex.weight)
                continue;
            for (int j = 0; j < graph.get(apex.to).size(); j++) {
                int weight = dis[apex.to] + graph.get(apex.to).get(j).weight;
                if (weight < dis[graph.get(apex.to).get(j).to]) {
                    dis[graph.get(apex.to).get(j).to] = weight;
                    pq.offer(new Apex(graph.get(apex.to).get(j).to, weight));
                    if (weight > max) {
                        max = weight;
                        index = graph.get(apex.to).get(j).to;
                    }
                }
            }
        }
    }
}

class Apex implements Comparable<Apex> {
    int to;
    int weight;

    public Apex(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Apex o) {
        return this.weight - o.weight;
    }
}
