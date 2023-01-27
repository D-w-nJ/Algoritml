package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BjStack2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0)
                s.pop();
            else
                s.push(tmp);
        }

        int result = 0;
        while (!s.empty())
            result += s.pop();

        System.out.println(result);
    }
}
