package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BjQueue4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st1.nextToken());
            int target = Integer.parseInt(st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Deque<int[]> d = new LinkedList<>();
            for (int j = 0; j < num; j++) {
                d.offerLast(new int[]{j, Integer.parseInt(st2.nextToken())});
            }
            int seq = 0;

            while (true) {
                int[] now = d.pollFirst();
                boolean flag = true;
                for (int[] tmp : d) {
                    if (tmp[1] > now[1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    seq++;
                    if (now[0] == target) {
                        sb.append(seq).append("\n");
                        break;
                    }
                } else {
                    d.offerLast(now);
                }
            }
        }
        System.out.println(sb);
    }
}
