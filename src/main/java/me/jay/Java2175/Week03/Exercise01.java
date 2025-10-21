package me.jay.Java2175.Week03;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Initial Value: ");
        final double initVal = scanner.nextDouble();

        System.out.print("Ratio: ");
        final double ratio = scanner.nextDouble();

        System.out.print("Length: ");
        final int length = scanner.nextInt();

        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += initVal * Math.pow(ratio, i);
        }
        System.out.printf("Sum: %f", sum);
    }
}
