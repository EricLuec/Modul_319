package todomanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println("\nTodo Manager:");
            System.out.println("1. Todo hinzufügen");
            System.out.println("2. Alle Todos anzeigen");
            System.out.println("3. Todos nach Kategorie anzeigen");
            System.out.println("4. Todo als erledigt markieren");
            System.out.println("5. Todo entfernen");
            System.out.println("6. Beenden");
            System.out.print("Wähle eine Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Titel des Todos: ");
                    String title = scanner.nextLine();
                    System.out.print("Beschreibung des Todos: ");
                    String description = scanner.nextLine();
                    System.out.print("Kategorie des Todos: ");
                    String category = scanner.nextLine(); // Eingabe für Kategorie
                    Todo todo = new Todo(title, description, category);
                    todoList.addTodo(todo);
                    break;
                case 2:
                    todoList.showTodos();
                    break;
                case 3:
                    System.out.print("Welche Kategorie möchtest du anzeigen? ");
                    String categoryFilter = scanner.nextLine();
                    todoList.showTodosByCategory(categoryFilter);
                    break;
                case 4:
                    System.out.print("Index des Todos zum Markieren (0-basierend): ");
                    int markIndex = scanner.nextInt();
                    todoList.markAsDone(markIndex);
                    break;
                case 5:
                    System.out.print("Index des Todos zum Entfernen (0-basierend): ");
                    int removeIndex = scanner.nextInt();
                    todoList.removeTodo(removeIndex);
                    break;
                case 6:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }
}
