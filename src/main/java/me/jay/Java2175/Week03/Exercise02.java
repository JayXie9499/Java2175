package me.jay.Java2175.Week03;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Number of Students: ");
        final int students = scanner.nextInt();

        System.out.print("Number of Courses: ");
        final int courses = scanner.nextInt();

        for (int i = 0; i < students; i++) {
            double sum = 0;
            System.out.printf("Student (%d)\n", i + 1);
            for (int j = 0; j < courses; j++) {
                System.out.printf("Subject %d: ", j + 1);
                sum += scanner.nextDouble();
            }
            System.out.printf("Average: %f\n", sum / courses);
        }
    }
}
