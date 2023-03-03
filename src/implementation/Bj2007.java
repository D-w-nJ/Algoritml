package implementation;

import java.util.Scanner;

public class Bj2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int sum = 0;
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < x - 1; i++) {
            sum += days[i];
        }
        sum += y;

        String result = "";

        switch(sum%7){
            case 0:
                result = "SUN";
                break;
            case 1:
                result = "MON";
                break;
            case 2:
                result = "TUE";
                break;
            case 3:
                result = "WED";
                break;
            case 4:
                result = "THU";
                break;
            case 5:
                result = "FRI";
                break;
            case 6:
                result = "SAT";
                break;
        }
        System.out.println(result);
    }
}
