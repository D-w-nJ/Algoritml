package dp;

import java.util.Scanner;

public class Bj24416 {
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        fib(N);
        fibonacci(N);

        System.out.println(a + " " + b);
    }


    static int fib(int N) {
        if (N == 1 || N == 2){
            a++;
            return 1;
        }
        else{
            return (fib(N - 1) + fib(N - 2));
        }

    }

    static int fibonacci(int N) {
        int[] f = new int[N];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < N; i++) {
            b++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[N - 1];

    }
}
