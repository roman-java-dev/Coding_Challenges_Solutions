package org.example.task2;

public class NumberTransformer {

    /**
     * Transforms a number by adding one to each of its digits. If a 9 is encountered,
     * it inserts a 10 instead.
     *
     * @param number The input number to be transformed.
     * @return The transformed number.
     */

    public static long transform(long number) {
        long result = 0;
        long multiplier = 1;

        while (number > 0) {
            long digit = number % 10;

            // Calculate the addend based on the digit value
            long addend = (digit == 9) ? 10 : (digit + 1);

            // Add the addend multiplied by the current multiplier to the result
            result += addend * multiplier;

            // Move to the next digit by dividing the number
            number /= 10;

            // Update the multiplier for the next digit
            multiplier *= (digit == 9) ? 100 : 10;
        }

        return result;
    }
}