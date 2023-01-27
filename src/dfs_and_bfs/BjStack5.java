package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BjStack5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int num = 1;

        for (int i = 0; i < n; i++) {
            if (s.empty() || s.peek() < arr[i]) {
                while (s.empty() || s.peek() != arr[i]) {
                    s.push(num++);
                    sb.append("+\n");
                }
                s.pop();
                sb.append("-\n");
            } else if (s.peek() == arr[i]) {
                s.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
