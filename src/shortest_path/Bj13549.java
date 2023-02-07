package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj13549 {
    static int time = 100001;
    static int N, K;
    static boolean[] visited = new boolean[100001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
            System.out.println(time);
        }
    }

    static void bfs(int start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.index == K) {
                time = Math.min(time, p.distance);
            }
            int next;
            next = p.index * 2;
            if (next < 100001 && !visited[next]) {
                visited[next] = true;
                q.offer(new Point(next, p.distance));
            }
            next = p.index - 1;
            if (next >= 0 && !visited[next]) {
                visited[next] = true;
                q.offer(new Point(next, p.distance + 1));
            }
            next = p.index + 1;
            if (next < 100001 && !visited[next]) {
                visited[next] = true;
                q.offer(new Point(next,p.distance+1));
            }

        }
    }
}

class Point implements Comparable<Point> {
    int index;
    int distance;

    @Override
    public int compareTo(Point o) {
        return this.distance - o.distance;
    }

    public Point(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}
