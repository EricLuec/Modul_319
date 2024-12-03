package ch.tbz;

import static ch.tbz.lib.Input.*;
import static java.lang.System.out;

public class I2 {
    public static void main(String[] args) {
        int bottleChecker;
        boolean rerunProgram;
        int definitiveBoxes = 0;

        do {
            System.out.println("Kastenrechner");
            out.println();
            bottleChecker = inputInt("Anzahl Flaschen? ");

            while (bottleChecker >= 6) {
                bottleChecker -= 6;
                definitiveBoxes++;
            }
            while (bottleChecker < 6) {
                definitiveBoxes++;
                break;
            }
            out.println("Sie brauchen : " + definitiveBoxes + " Harasssen");

            boolean calculateAgain = inputBoolean("Wollen sie nochmals rechnen? ");
            rerunProgram = calculateAgain;
        } while (bottleChecker <= 0 || rerunProgram);
    }

}
