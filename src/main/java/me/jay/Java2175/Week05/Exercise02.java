package me.jay.Java2175.Week05;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Calculate Harmonic series of n");
        System.out.print("n: ");
        final int n = scanner.nextInt();
        final double result = calcHarmonic(n);
        System.out.printf("H(%d) = %f\n", n, result);
    }

    private static double calcHarmonic(int n) {
        if (n == 1) {
            return 1;
        }

        return (double) 1 / n + calcHarmonic(n - 1);
    }
}
