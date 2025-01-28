package org.example.level4fx;

import java.util.ArrayList;
import java.util.List;

// basic functionality of the todolist with filter functions
public class TodoList {
    private List<Todo> todos;

    public TodoList() {
        todos = new ArrayList<>();
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void markAsDone(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.get(index).setDone(true);
        }
    }

    public void removeTodo(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.remove(index);
        }
    }

    public List<Todo> getTodosByCategory(String category) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getCategory().equalsIgnoreCase(category)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}