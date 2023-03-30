package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<int[]>> map = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            map.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(root).add(new int[]{to, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int[] graph = new int[N + 1];
        Arrays.fill(graph, 100000000);
        graph[root] = 0;

        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(root, 0));
        while (!pq.isEmpty()) {
            Road road = pq.poll();
            if(graph[road.to]<road.cost)
                continue;
            for (int i = 0; i < map.get(road.to).size(); i++) {
                int cost = graph[road.to] + map.get(road.to).get(i)[1];
                if (cost < graph[map.get(road.to).get(i)[0]]) {
                    graph[map.get(road.to).get(i)[0]] = cost;
                    pq.offer(new Road(map.get(road.to).get(i)[0], cost));
                }
            }
        }

        System.out.println(graph[to]);

    }
}

class Road implements Comparable<Road> {
    int to;
    int cost;

    public Road(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}
