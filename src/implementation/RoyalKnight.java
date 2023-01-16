package implementation;

import java.util.Scanner;

public class RoyalKnight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char colm = input.charAt(0);
        char row = input.charAt(1);

        int[][] arr = new int[8][2];

        int result = 0;

        int[] colmMove = {2, 2, 1, -1, -2, -2, 1, -1};
        int[] rowMove = {1, -1, 2, 2, 1, -1, -2, -2};
        for (int i = 0; i < 8; i++) {
            arr[i][0] = row + rowMove[i];
            arr[i][1] = colm + colmMove[i];

            if((arr[i][0]>='1')&&(arr[i][0]<='8')&&(arr[i][1]>='a')&&(arr[i][1]<='h'))
                result++;
        }

        System.out.println(result);
    }
}
