package example.greedy;

import java.util.Scanner;

public class Ex31 {

    static int[] coinTypes = new int[]{500, 100, 50, 10};

    public static void main(String[] args) {
        int totalAmount = getIntInput();
        int result = calculateChange(totalAmount);
        printIntValue(result);
    }

    private static int getIntInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int calculateChange(int totalAmount) {
        int remainingAmount = totalAmount;
        int coinCount = 0;

        for (int coinType : coinTypes) {
            coinCount += remainingAmount / coinType;
            remainingAmount = remainingAmount % coinType;
        }

        return coinCount;
    }

    private static void printIntValue(int result) {
        System.out.println(result);
    }
}
