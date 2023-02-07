package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus> {
    int index;
    int time;

    public Bus(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Bus bus) {
        return this.time - bus.time;
    }
}

public class Bj11657 {
    static ArrayList<ArrayList<Bus>> map;
    static int INF = 1000000000;
    static boolean[] visited;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        d = new int[N + 1];
        Arrays.fill(d, INF);
        Arrays.fill(visited, false);

        map = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            map.add(new ArrayList<>());
        }
        int sum = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).add(new Bus(b, c));
            if(c<0)
                sum +=c;
        }

        d[1] = 0;
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(1, 0));
        while (!pq.isEmpty()) {
            Bus bus = pq.poll();
            if (d[bus.index] < bus.time)
                continue;
            for (Bus b : map.get(bus.index)) {
                int cost = d[bus.index] + b.time;
                if (cost < d[b.index]) {
                    if(cost<sum*2){
                        System.out.println(-1);
                        return;
                    }
                    d[b.index] = cost;
                    pq.offer(new Bus(b.index, cost));
                }
            }
        }

        String str = "aaaaa";
        char a = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            if(d[i]==INF)
                sb.append("-1\n");
            else
                sb.append(d[i]+"\n");
        }

        System.out.println(sb);
    }
}
