package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Bj2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append((int)Math.rint((double)sum/N) + "\n");
        sb.append(arr[(N - 1) / 2] + "\n");

        int min = arr[0];
        int max = arr[N - 1];
        int[] arrA = new int[max - min + 1];
        for (int i = 0; i < N; i++) {
            arrA[arr[i] - min]++;
        }
        int maxI = 0;
        for (int i : arrA) {
            if (maxI < i) {
                maxI = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrA.length; i++) {
            if (maxI == arrA[i])
                list.add(i);
        }
        if (list.size() == 1)
            sb.append((list.get(0) + min) + "\n");
        else {
            Collections.sort(list);
            sb.append((list.get(1) + min) + "\n");
        }

        sb.append(arr[arr.length - 1] - arr[0]);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
