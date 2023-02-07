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

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}

public class Bj1504 {
    static int N, E;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        d = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        long result1 = 0;
        result1 += func(1, v1);
        result1 += func(v1, v2);
        result1 += func(v2, N);
        long result2 = 0;
        result2 += func(1, v2);
        result2 += func(v2, v1);
        result2 += func(v1, N);

        if (result1 >= INF && result2 >= INF) {
            System.out.println(-1);
        } else
            System.out.println(Math.min(result1, result2));

    }

    static int func(int start, int end) {
        Arrays.fill(d, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node o = pq.poll();
            if (d[o.getIndex()] < o.getDistance()) {
                continue;
            }
            for (int i = 0; i < graph.get(o.getIndex()).size(); i++) {
                Node nd = graph.get(o.getIndex()).get(i);
                if (nd.getDistance() + d[o.getIndex()] < d[nd.getIndex()]) {
                    d[nd.getIndex()] = nd.getDistance() + d[o.getIndex()];
                    pq.offer(new Node(nd.getIndex(), d[nd.getIndex()]));
                }
            }
        }
        return d[end];
    }
}
