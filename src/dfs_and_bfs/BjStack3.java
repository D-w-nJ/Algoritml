package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BjStack3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Loop1:
        for (int i = 0; i < n; i++) {
            Stack<Integer> s = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                try {
                    if (str.charAt(j) == '(')
                        s.push(1);
                    else
                        s.pop();
                } catch (Exception e) {
                    sb.append("NO\n");
                    continue Loop1;
                }
            }
            if(s.empty())
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
