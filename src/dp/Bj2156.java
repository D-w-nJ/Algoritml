package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2156 {
    static Integer[] resultA;
    static Integer[] resultB;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        resultA = new Integer[N];
        resultB = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(arr[0]);
            return;
        } else if (N == 2) {
            System.out.println(arr[0]+arr[1]);
            return;
        }
        resultB[2] = arr[0] + arr[2];
        resultA[1] = arr[0] + arr[1];
        resultB[1] = arr[1];

        System.out.println(Math.max(Math.max(func(N - 1, true), func(N - 1, false)), Math.max(func(N - 2, true), func(N - 2, false))));

    }

    static int func(int i, boolean flag) {
        if (i == 0)
            return arr[i];
        else if (flag) {
            if (resultA[i] != null)
                return resultA[i];
            resultA[i] = arr[i] + func(i - 1, false);
            return resultA[i];
        } else {
            if (resultB[i] != null)
                return resultB[i];
            resultB[i] = arr[i] + Math.max(Math.max(func(i - 2, true), func(i - 2, false)), Math.max(func(i - 3, true), func(i - 3, false)));
            return resultB[i];
        }
    }
}
