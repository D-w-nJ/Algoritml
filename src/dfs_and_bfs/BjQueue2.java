package dfs_and_bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BjQueue2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> d = new LinkedList<>();

        for (int i = n; i > 0; i--) {
            d.offerFirst(i);
        }

        while (d.size() != 1) {
            d.pollFirst();
            if (d.size() == 1) break;
            int tmp = d.pollFirst();
            d.offerLast(tmp);
        }
        System.out.println(d.peek());
    }
}
