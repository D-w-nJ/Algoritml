package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BjDeque1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> d = new LinkedList<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push_front":
                    d.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    d.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(d.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(d.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(d.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(d.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(d.size()).append("\n");
                    break;
                case "empty":
                    int tmp = (d.isEmpty()) ? 1 : 0;
                    sb.append(tmp).append("\n");
                    break;
                case "front":
                    if(d.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(d.peekFirst()).append("\n");
                    break;
                case "back":
                    if(d.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(d.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
