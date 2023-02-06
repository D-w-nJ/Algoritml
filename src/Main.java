import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int a = 1;
        int b = 1;
        for (int i = 1; i <= N; i++) {
            a *= i;
        }
        for (int i = 1; i <= K; i++) {
            b *= i;
        }
        int c = 1;
        for (int i = 1; i <= (N - K); i++) {
            c *= i;
        }
        System.out.println(a/(b*c));

    }
}