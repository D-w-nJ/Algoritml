package dfs_and_bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BjQueue3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Deque<Integer> d = new LinkedList<>();

        String result = "<";

        for (int i = 1; i <= N; i++) {
            d.offerLast(i);
        }

        int num = 1;

        while (!d.isEmpty()) {
            if (num++ % K == 0)
                result += d.pollFirst() + ", ";
            else
                d.offerLast(d.pollFirst());
        }

        System.out.println(result.substring(0, result.length() - 2) + ">");
    }
}
