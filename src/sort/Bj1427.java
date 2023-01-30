package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Bj1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = str.length();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = num-1; i >=0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
