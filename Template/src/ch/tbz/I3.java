package ch.tbz;

import static ch.tbz.lib.Input.*;
import static java.lang.System.out;

public class I3 {

    // methode zur Flächenberechung
    private static void spaceCalc() {
        out.println("Gebe die Seitenlängen in cm an:");
        int firstSide = inputInt("[1] Seite");
        int secondSide = inputInt("[2] Seite");
        int calculatedSpace = firstSide * secondSide;
        out.println("Ihre Fläche beträgt: " + calculatedSpace + "cm.");
    }

    // Methode für Gewichtsberechnung
    private static void weightCalculation() {
        out.println("Gib die Masseinheit an die du verrechnen Möchtest");
        out.println("[1] KG");
        out.println("[2] Pfund");
        out.println("[3] Tonnen");
        int calculatingWeight = inputInt("Zu verrechnende Gewichtseinheit");
        int goalWeightCategory = inputInt("Ziel-Gewichtseinheit");
        int weightInput = inputInt("Geben sie nun das zu verrechnende Gewicht in der entsprechenden Einheit ein");
        double gramIndicator = 0;

        if (calculatingWeight == 1) {
            gramIndicator = weightInput * 1000;
        } else if (calculatingWeight == 2) {
            gramIndicator = weightInput * 453.592;
        } else if (calculatingWeight == 3) {
            gramIndicator = weightInput * 1000000;
        }

        double WeightResult = 0;
        if (goalWeightCategory == 1) {
            WeightResult = gramIndicator / 1000;
        } else if (goalWeightCategory == 2) {
            WeightResult = gramIndicator / 453.592;
        } else if (goalWeightCategory == 3) {
            WeightResult = gramIndicator / 1000000;
        }
        out.println("Resultat: " + WeightResult);
    }

    // Methode zur Pythagorasberechnung
    private static void pythagorasCalc() {
        out.println("Welche Seite des Dreiecks möchtest du berechnen?");
        out.println("[1] Kathete");
        out.println("[2] Kathete");
        out.println("[3] Hypotenuse");
        int sideSelector = inputInt("Gib die Seite an:");
        out.println("Gib nun die beiden bekannten Seiten an:");
        int firstSide = inputInt("[1] Seite:");
        int secondSide = inputInt("[2] Seite:");
        double calculatedSide = 0;

        if (sideSelector == 3) {
            calculatedSide = (Math.sqrt((firstSide * firstSide) + (secondSide * secondSide)));
        } else {
            calculatedSide = (Math.sqrt((firstSide * firstSide) - (secondSide * secondSide)));
        }
        out.println("Unbekannte Seite: " + calculatedSide);
    }

    // Mainmethode
    public static void main(String[] args) {
        boolean rerunProgram;
        do {
            out.println("Berechnungsfunktionen:");
            out.println("[1] Fläche");
            out.println("[2] Masseinheiten");
            out.println("[3] Pythagoras");
            int functionHolder = inputInt("Wähle eine Funktion:");

            // Conditionals welche Methode ausgeführt wird.
            if (functionHolder == 1) {
                spaceCalc();
            } else if (functionHolder == 2) {
                weightCalculation();
            } else if (functionHolder == 3) {
                pythagorasCalc();
            }
            // Check ob das Programm beendet wird oder nochmals ausgeführt.
            boolean calculateAgain = inputBoolean("Wollen sie nochmals rechnen? ");
            rerunProgram = calculateAgain;

        } while (rerunProgram) ;
    }
}
