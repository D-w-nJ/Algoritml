package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BjStack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    int m = Integer.parseInt(st.nextToken());
                    s.push(m);
                    break;
                case "top":
                    if (s.empty())
                        sb.append(-1 + "\n");
                    else
                        sb.append(s.peek() + "\n");
                    break;
                case "size":
                    sb.append(s.size() + "\n");
                    break;
                case "empty":
                    if (s.empty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "pop":
                    if (s.empty())
                        sb.append(-1 + "\n");
                    else
                        sb.append(s.pop() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
