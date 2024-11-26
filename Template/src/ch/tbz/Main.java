// Defines package
package ch.tbz;

// Imports libraries
import static java.lang.System.*;   // System-IO Library for abbriviation purpose to static functions
import static java.lang.Math.*;     // Mathematic Library for abbriviation purpose to static functions
import java.util.*;                 // Random is part of this library

// Imports Input functions
import static ch.tbz.lib.Input.*;       // All the functions can be used now!

//Every program must be placed in a class ...
public class Main {

    // Our main function which runs the program12
    public static void main(String[] args ) {
        boolean rerunProgram;
        do {
            // Title
            System.out.println("Währungsrechner");
            out.println();

            // Input
            float shoePrice = inputFloat("Wie viel kostet der Schuh? ");
            float transportCost = inputFloat("Geben Sie die Transportkosten ein: ");
            float exchangeRate = inputFloat("Geben Sie den Wechselkurs ein: ");

            // Calculation
            double calculatePrice = Math.round(shoePrice + transportCost) * exchangeRate;

            // System.Out function (Short version)
            out.println("Das Resultat ist: " + calculatePrice);
            boolean calculateAgain = inputBoolean("Wollen sie nochmals rechnen? ");
            rerunProgram = calculateAgain;
        } while (rerunProgram);


    }
}
