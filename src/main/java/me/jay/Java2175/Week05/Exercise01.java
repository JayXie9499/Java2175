package me.jay.Java2175.Week05;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Calculate C(N, M)");
        System.out.print("N: ");
        final int n = scanner.nextInt();

        System.out.print("M: ");
        final int m = scanner.nextInt();

        final double combination = calcCombination(n, m);
        System.out.printf("C(%d, %d) = %f\n", n, m, combination);
    }

    private static int calcFactorial(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    private static double calcCombination(int n, int m) {
        double nFactorial = calcFactorial(n);
        double mFactorial = calcFactorial(m);
        double diffFactorial = calcFactorial(n - m);

        return nFactorial / (mFactorial * diffFactorial);
    }
}
