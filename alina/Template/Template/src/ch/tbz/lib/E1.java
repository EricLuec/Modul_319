package ch.tbz.lib;
import java.util.Scanner;
public class E1 {public static void main(String[] args) {
    //include scanner for reading input
    Scanner scan = new Scanner(System.in);

    int input;  //declare variable

    System.out.println("Geben Sie eine Zahl zwischen 2 und 6 ein:");

    input = scan.nextInt();

    if ((input >= 2) && (input <= 6)) {
        int zaehler = 0;
        for (int i = -5; i < 5; i++) {
            zaehler = zaehler + i + input;
            System.out.println(zaehler);
        }

    } else {
        System.err.println("Achtung, falsche Eingabe!");
    }
    System.out.println("und fertig!");

    scan.close();
}
}

/*
Lösungen:
1.) 15
2.) 15
3.) F9
4.) -5
 */