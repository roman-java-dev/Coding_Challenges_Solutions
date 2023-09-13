package org.example.task1;

public class Main {
    private final static String TEST_STRING = "WEAREDISCOVEREDFLEEATONCE";

    public static void main(String[] args) {
        String encoded = RailFenceCipher.encode(TEST_STRING, 3);
        System.out.println("Encoded: " + encoded);

        String decoded = RailFenceCipher.decode(encoded, 3);
        System.out.println("Decoded: " + decoded);

    }
}