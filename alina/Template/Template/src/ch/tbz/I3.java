package ch.tbz;
import java.util.ArrayList;
import java.util.Scanner;

public class I3 {

    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do Liste - Wähle eine Option:");
            System.out.println("1. Aufgabe hinzufügen");
            System.out.println("2. Aufgaben anzeigen");
            System.out.println("3. Aufgabe löschen");
            System.out.println("4. Beenden");
            System.out.print("Deine Wahl: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Neue Aufgabe: ");
                    String task = scanner.nextLine();
                    todoList.add(task);
                    System.out.println("Aufgabe hinzugefügt.");
                    break;

                case 2:
                    System.out.println("\nDeine Aufgaben:");
                    if (todoList.isEmpty()) {
                        System.out.println("Keine Aufgaben in der Liste.");
                    } else {
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Welche Aufgabe möchtest du löschen? (Nummer eingeben)");
                    if (todoList.isEmpty()) {
                        System.out.println("Keine Aufgaben zum Löschen.");
                    } else {
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                        System.out.print("Nummer: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (taskNumber > 0 && taskNumber <= todoList.size()) {
                            todoList.remove(taskNumber - 1);
                            System.out.println("Aufgabe gelöscht");
                        } else {
                            System.out.println("Falsche Nummer, diese Nummer exestiert nicht");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
            }
        }
    }
}