package ch.tbz.lib;

import java.util.Scanner;
import static ch.tbz.lib.Input.inputBoolean;

public class D3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean fortfahren = false;
        do  {
            System.out.println("Bitte geben Sie einen Satz ein:");
            String satz = scanner.nextLine();

            int zaehlerSelbstlaute = 0;
            String neuerSatz = "";

            for (int i = 0; i < satz.length(); i++) {
                char aktuellesZeichen = satz.charAt(i);
                if ("aeiouAEIOU".contains(String.valueOf(aktuellesZeichen))) {
                    zaehlerSelbstlaute++;
                    neuerSatz += Character.toUpperCase(aktuellesZeichen);
                } else {
                    neuerSatz += aktuellesZeichen;
                }
            }

            System.out.println("Anzahl der Selbstlaute: " + zaehlerSelbstlaute);
            System.out.println("Abgeänderter Satz: " + neuerSatz);

            boolean runAgain = inputBoolean("nochmal?");
            fortfahren = runAgain;
        } while (fortfahren);
        scanner.close();
    }
}
