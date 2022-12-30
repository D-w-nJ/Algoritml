package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Until1 {
    public static void main(String[] args) throws IOException {
        // N과 K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // N이 1이 될때가지 카운트

        // 내 답
//        int count = 0;
//        while (true) {
//            if ((n % m) == 0) {
//                if (n == 1) break;
//                n = n / m;
//                count++;
//            } else {
//                if (n == 1) break;
//                n--;
//                count++;
//            }
//        }
//        System.out.println(count);
        // 이때는 n이 m으로 나누어지지 않을 때 1을 계속 뺴야함.
        int result = 0;
        while (true) {
            // N이 M으로 나누어 떨어지는 수가 될 때까지 1씩 빼기
            int target = (n / m) * m;
            result += n - target;
            n = target;
            if (n < m) break;
            result += 1;
            n /= m;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += n - 1;
        System.out.println(result);
    }
}
