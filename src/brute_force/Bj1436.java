package brute_force;

import java.util.ArrayList;
import java.util.Scanner;

public class Bj1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int i = 666; i < 100000000; i++) {
            int cnt = 0;
            String tmp = String.valueOf(i);
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == '6') {
                    cnt++;
                    if (cnt == 3) {
                        al.add(i);
                    }
                } else {
                    cnt = 0;
                }
            }
            if (al.size() == N) {
                System.out.println(al.get(N - 1));
                break;
            }
        }
    }
}
