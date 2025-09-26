package me.jay.Java2175.Week01;

import java.util.Scanner;

public class Exercise01 {
    // ax^2 + bx + c = 0 求根
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();
        final double delta = b * b - 4 * a * c;

        if (delta < 0) {
            System.out.println("無解");
        } else {
            System.out.println((-b + Math.sqrt(delta)) / (2 * a));
            System.out.println((-b - Math.sqrt(delta)) / (2 * a));
        }
    }
}
