package ch.tbz;

import java.util.Scanner;

public class D3 {
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib einen Satz ein:");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        System.out.println("Anzahl der Wörter: " + words.length);
        System.out.println("Die Wörter sind:");

        for (String word : words) {
            System.out.println(word);
        }
        scanner.close();
    }
}
