package org.example.task2;

import java.util.Scanner;

import static org.example.task2.NumberTransformer.transform;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter a number and click ENTER");
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextLong()) {
                System.out.println("You entered an incorrect number. "
                        + "Try to enter a number without characters");
                scanner.next();
            }

        long inputNumber = scanner.nextLong();
        System.out.printf("Your number is %s", transform(inputNumber));
    }
}
