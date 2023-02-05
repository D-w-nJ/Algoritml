package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}

public class Ndb9_1_1 {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int INF = (int) 1e9;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        d = new int[V + 1];
        Arrays.fill(d, INF);

        shortestPath(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(d[i]==INF)
                sb.append("INF\n");
            else
                sb.append(d[i]+"\n");
        }
        System.out.println(sb);
    }

    static void shortestPath(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int index = n.getIndex();
            int distance = n.getDistance();
            if (d[index] < distance)
                continue;
            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if (cost < d[graph.get(index).get(i).getIndex()]) {
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(index).get(i).getIndex(),cost));
                }
            }

        }
    }
}
