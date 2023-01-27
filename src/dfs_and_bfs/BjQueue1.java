package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BjQueue1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> d = new LinkedList<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    d.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if (d.isEmpty()) sb.append("-1\n");
                    else sb.append(d.peekLast() + "\n");
                    break;
                case "pop":
                    if (d.isEmpty()) sb.append("-1\n");
                    else sb.append(d.pollLast() + "\n");
                    break;
                case "size":
                    sb.append(d.size() + "\n");
                    break;
                case "empty":
                    if (d.isEmpty()) sb.append("1" + "\n");
                    else sb.append("0" + "\n");
                    break;
                case "back":
                    if (d.isEmpty()) sb.append("-1\n");
                    else sb.append(d.peekFirst() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
