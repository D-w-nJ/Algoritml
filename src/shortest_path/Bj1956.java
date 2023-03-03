package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int to, int distance) {
        this.index = to;
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

public class Bj1956 {
    static int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        int[][] arr = new int[V + 1][V + 1];

        for (int i = 1; i < V + 1; i++) {
            Arrays.fill(arr[i], INF);
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
        }

        for (int i = 1; i <= V; i++) {
            func(i, arr[i]);
        }
        int min = INF;

        for (int i = 1; i < V; i++) {
            for (int j = i + 1; j <= V; j++) {
                if(arr[i][j]==INF||arr[j][i]==INF)
                    continue;
                if (min > arr[i][j] + arr[j][i])
                    min = arr[i][j] + arr[j][i];
            }
        }
        if (min == INF) {
            System.out.println(-1);
        }else
            System.out.println(min);


    }

    static void func(int root, int[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        arr[root] = 0;
        pq.offer(new Node(root, 0));
        while (!pq.isEmpty()) {
            Node nd = pq.poll();
            int index = nd.getIndex();
            int distance = nd.getDistance();
            if (arr[index] < distance)
                continue;
            for (int i = 0; i < list.get(index).size(); i++) {
                int cost = arr[index] + list.get(index).get(i).getDistance();
                if (cost < arr[list.get(index).get(i).getIndex()]) {
                    arr[list.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node(list.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }
}

