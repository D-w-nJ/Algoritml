package dfs_and_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj1697 {
    static int[] arr = new int[100001];
    static int target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        target = sc.nextInt();

        Arrays.fill(arr, 1000000000);

        bfs(N);
        System.out.println(arr[target]);
    }

    static void bfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        arr[N] = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (tmp > 0) {
                if(arr[tmp] + 1 < arr[tmp - 1]){
                    arr[tmp - 1] = arr[tmp] + 1;
                    q.offer(tmp - 1);
                }
            }
            if (tmp < 100000) {
                if(arr[tmp] + 1 < arr[tmp + 1]) {
                    arr[tmp + 1] = arr[tmp] + 1;
                    q.offer(tmp + 1);
                }
            }
            if (tmp * 2 < 100001) {
                if(arr[tmp] + 1 < arr[tmp * 2]){
                    arr[tmp * 2] = arr[tmp] + 1;
                    q.offer(tmp * 2);
                }
            }
        }
    }
}
