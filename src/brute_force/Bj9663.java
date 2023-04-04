package brute_force;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Bj9663 {
    static int sum = 0;
    static int[] flag;
    static int N;
    static boolean[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            flag = new int[N];
            boolean[] b = new boolean[N];
            b[i] = true;
            dfs(i, 0, b);
        }

        System.out.println(sum);
    }

    static void dfs(int i, int num, boolean[] tmp) {
        flag[i] = num;
        if (num == N - 1) {
//            for (int j = 0; j < N; j++)
//                Arrays.fill(map[j], false);
//            func(flag);
            System.out.println(Arrays.toString(flag));
        }else{
            for (int j = 0; j < N; j++) {
                if (!tmp[j]) {
                    tmp[j] = true;
                    dfs(j, num + 1, tmp);
                    tmp[j] = false;
                }
            }
        }
    }


    static void func(int[] flag) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(flag[i] + i);
            bSet.add(flag[i] - i);
        }

        if (set.size() == N && bSet.size() == N) {
            sum++;
        }
    }
}
