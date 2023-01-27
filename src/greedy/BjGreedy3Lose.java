package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class BjGreedy3Lose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] strArr = str.split("\\+|-");
        ArrayList<Character> chars = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-')
                chars.add(str.charAt(i));
        }

        int sum = Integer.parseInt(strArr[0]);
        int tmp = 0;
        for (int i = 0; i < strArr.length - 1; i++) {
            if (chars.get(i) == '-')
                tmp += 1;
            if (tmp % 2 == 0)
                sum += Integer.parseInt(strArr[i]);
            else
                sum -= Integer.parseInt(strArr[i]);
        }
        System.out.println(sum);
    }
}
