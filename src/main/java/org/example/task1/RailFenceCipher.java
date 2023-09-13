package org.example.task1;

import org.example.exception.InvalidInputParamException;

public class RailFenceCipher {
    private final static String EMPTY_LINE = "";

    // Method for encoding a string using the Rail Fence Cipher
    static String encode(String string, int numberOfRails) {
        if (string.isEmpty()) {
            return EMPTY_LINE;
        }
        checkInputParam(string, numberOfRails);
        StringBuilder encodedString = new StringBuilder();
        int railIncrement = 2 * numberOfRails - 2; // Calculate the rail increment

        for (int i = 0; i < numberOfRails; i++){
            int railDistance = railIncrement;
            int currentIndex = i;

            while(currentIndex < string.length()){
                encodedString.append(string.charAt(currentIndex)); // Append the character to the encoded string
                currentIndex += railDistance; // Move to the next character on this rail

                // Change the rail distance if it's not the last rail
                if (railDistance != 2 * numberOfRails - 2) {
                    railDistance = 2 * numberOfRails - 2 - railDistance;
                }
            }

            // Reset the rail increment if it's 2
            if (railIncrement == 2) {
                railIncrement = 2 * numberOfRails - 2;
            } else {
                railIncrement -= 2;
            }
        }
        return encodedString.toString();
    }

    // Method for decoding a string encoded with the Rail Fence Cipher
    public static String decode(String string, int numberOfRails){
        if (string.isEmpty()) {
            return EMPTY_LINE;
        }
        checkInputParam(string, numberOfRails);
        char[] decodedChars = new char[string.length()];
        int decodedIndex = 0;
        int railIncrement = 2 * numberOfRails - 2; // Calculate the rail increment

        for (int i = 0; i < numberOfRails; i++) {
            int railDistance = railIncrement;
            int currentIndex = i;

            while(currentIndex < string.length()){
                decodedChars[currentIndex]= string.charAt(decodedIndex++);
                currentIndex += railDistance; // Move to the next character on this rail

                // Move to the next character on this rail
                if (railDistance != 2 * numberOfRails - 2) {
                    railDistance = 2 * numberOfRails - 2 - railDistance;
                }
            }

            // Reset the rail increment if it's 2
            if (railIncrement == 2) {
                railIncrement = 2 * numberOfRails - 2;
            } else {
                railIncrement -= 2;
            }
        }
        return new String(decodedChars);
    }

    private static void checkInputParam(String string, int numberOfRails) {
        if (numberOfRails <= 1 || string.length() <= numberOfRails) {
            throw new InvalidInputParamException("Invalid params. The number of rails should "
                    + "be greater than 1 and less than the length of the input string.");
        }
    }
}