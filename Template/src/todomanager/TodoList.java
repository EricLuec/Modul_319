package todomanager;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todos;

    // Konstruktor
    public TodoList() {
        todos = new ArrayList<>();
    }

    // Todo hinzufügen
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    // Alle Todos anzeigen
    public void showTodos() {
        if (todos.isEmpty()) {
            System.out.println("Keine Todos vorhanden.");
        } else {
            for (Todo todo : todos) {
                System.out.println(todo);
            }
        }
    }

    // Todos nach Kategorie anzeigen
    public void showTodosByCategory(String category) {
        boolean found = false;
        for (Todo todo : todos) {
            if (todo.getCategory().equalsIgnoreCase(category)) {
                System.out.println(todo);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Keine Todos in dieser Kategorie gefunden.");
        }
    }

    // Todo als erledigt markieren
    public void markAsDone(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.get(index).setDone(true);
            System.out.println("Todo " + todos.get(index).getTitle() + " wurde erledigt.");
        } else {
            System.out.println("Ungültiger Index.");
        }
    }

    // Todo entfernen
    public void removeTodo(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.remove(index);
            System.out.println("Todo wurde entfernt.");
        } else {
            System.out.println("Ungültiger Index.");
        }
    }
}