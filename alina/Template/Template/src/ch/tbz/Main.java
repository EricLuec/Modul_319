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
        boolean nochmalRechnen;
        do {
            // Title
            System.out.println("Dreiecksberechnung:");
            out.println();

            // Input
            double a = inputDouble("Geben Sie den Schuhpreis an: ");
            double b = inputDouble("Geben Sie den Transportpreis ein: ");
            double d = inputDouble("Geben Sie die Umrechnungsrate an: ");

            // Calculation
            double c = Math.round((a + b) * d);

            // System.Out function (Short version)
            out.println("Das Resultat ist: " + c);
            boolean nochmalRechnenIndicator = inputBoolean("Nochmal rechnen?: ");
            nochmalRechnen = nochmalRechnenIndicator;
        } while (nochmalRechnen);
    }
}
