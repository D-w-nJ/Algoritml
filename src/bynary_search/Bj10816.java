package bynary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj10816 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            for (int j=0;j<N;j++) {
                if (arr[j] == target) {
                    result[i]++;
                }
                j++;
            }
            sb.append(result[i] + " ");
        }


        System.out.println(sb);
    }
}
