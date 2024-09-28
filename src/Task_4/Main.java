package Task_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        Symbol[] counts = getCharacterCounts(input);

        for (Symbol charCount : counts) {
            System.out.println("Character: '" + charCount.getCharacter() + "', Count: " + charCount.getCount());
        }
    }

    private static Symbol[] getCharacterCounts(final String input) {
        final int ASCII_SIZE = 128;
        int[] frequency = new int[ASCII_SIZE];

        for (char c : input.toCharArray()) {
            frequency[c]++;
        }

        Symbol[] tempCounts = new Symbol[ASCII_SIZE];
        int count = 0;

        for (int i = 0; i < ASCII_SIZE; i++) {
            if (frequency[i] > 0) {
                tempCounts[count++] = new Symbol((char) i, frequency[i]);
            }
        }

        Symbol[] result = new Symbol[count];

        System.arraycopy(tempCounts, 0, result, 0, count);

        return result;
    }

}
