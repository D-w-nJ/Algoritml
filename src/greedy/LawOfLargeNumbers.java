package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LawOfLargeNumbers {
    public static void main(String[] args) throws IOException {
        // N, M, K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();

        StringTokenizer st1 = new StringTokenizer(line1);
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        // 배열 입력받기
        int[] arr = new int[N];
        String line2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line2);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        // 배열 오름차순 정렬
        Arrays.sort(arr);

        // 내 답
//        int sub = arr[N - 1] - arr[N - 2];
//        int subNum = M / K;
//        int sum = arr[N - 1] * M - sub * subNum;
//        System.out.println(sum);

        // 동빈s 답
        int sum = 0;

        while (true) {
            for (int i = 0; i < K; i++) {
                if (M == 0) break;
                sum += arr[N - 1];
                M--;
            }
            if (M == 0) break;
            sum += arr[N - 2];
            M--;
        }
        System.out.println(sum);

        // 가장 큰 수가 더해지는 횟수 : (M / (K+1)) * k + M % (K+1)
        // 그다음 큰 수가 더해지는 횟수 : M / (k+1) 또는 M - 큰수 더해지는 횟수
        // -> arr[N-1]*큰수가 더해지는 횟수 + arr[N-2]* 그다음 큰 수가 더해지는 횟수
    }
}
