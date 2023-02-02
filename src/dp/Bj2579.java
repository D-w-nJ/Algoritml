package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2579 {
    static int[] arr;
    static Integer[] resultA;
    static Integer[] resultB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        resultA = new Integer[N + 1];
        resultB = new Integer[N + 1];
        arr[0] = 0;

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(func(N, false));
    }

    static int func(int i, boolean flag) {
        if (i == 1 || i == 0) {
            return arr[i];
        } else if (flag) {
            if(resultA[i]!=null)
                return resultA[i];
            resultA[i] = arr[i] + func(i - 2, false);
            return resultA[i];
        } else {
            if(resultB[i]!=null)
                return resultB[i];
            resultB[i] = arr[i] + Math.max(func(i - 1, true), func(i - 2, false));
            return resultB[i];
        }
    }
}
