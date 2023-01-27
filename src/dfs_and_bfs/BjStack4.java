package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BjStack4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Loop1:
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<Boolean> s = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                try {
                    char tmp = str.charAt(i);
                    if (tmp == '[') {
                        s.push(true);
                    } else if (tmp == '(') {
                        s.push(false);
                    } else if (tmp == ']') {
                        if (s.peek())
                            s.pop();
                        else {
                            sb.append("no\n");
                            continue Loop1;
                        }
                    } else if (tmp == ')') {
                        if (!s.peek())
                            s.pop();
                        else {
                            sb.append("no\n");
                            continue Loop1;
                        }
                    }
                } catch (Exception e) {
                    sb.append("no\n");
                    continue Loop1;
                }
            }
            if (s.empty())
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.println(sb);
    }
}
