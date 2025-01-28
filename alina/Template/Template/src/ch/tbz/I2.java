package ch.tbz;

import java.util.Scanner;

public class I2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bitte geben Sie die erste Zahl ein:");
            int zahl1 = scanner.nextInt();

            System.out.println("Bitte geben Sie die zweite Zahl ein:");
            int zahl2 = scanner.nextInt();

            System.out.println("Bitte geben Sie die dritte Zahl ein:");
            int zahl3 = scanner.nextInt();

            int min = zahl1;
            if (zahl2 < min) min = zahl2;
            if (zahl3 < min) min = zahl3;

            int max = zahl1;
            if (zahl2 > max) max = zahl2;
            if (zahl3 > max) max = zahl3;

            System.out.println("Der kleinste Wert ist: " + min);
            System.out.println("Der größte Wert ist: " + max);

            if (zahl1 == zahl2 && zahl2 == zahl3) {
                System.out.println("Alle drei Zahlen sind gleich groß. Das Programm wird beendet.");
                break;
            }
        }

        scanner.close();
    }
}
