package org.example.level4fx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;

public class Main extends Application {
    private TodoList todoList = new TodoList();
    private ListView<String> todoListView = new ListView<>();
    private TextField titleField = new TextField();
    private TextField descriptionField = new TextField();
    private TextField categoryField = new TextField();
    private TextField searchField = new TextField();
    private Button addButton = new Button("Todo hinzufügen");
    private Button markDoneButton = new Button("Markieren als erledigt");
    private Button removeButton = new Button("Todo entfernen");
    private Button searchButton = new Button("Suchen");
    private Button resetButton = new Button("Zurücksetzen");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // scene / ui for javafx
        primaryStage.setTitle("Todo Manager");

        VBox root = new VBox(10);
        HBox inputBox = new HBox(10);
        HBox searchBox = new HBox(10);

        titleField.setPromptText("Titel");
        descriptionField.setPromptText("Beschreibung");
        categoryField.setPromptText("Kategorie");
        searchField.setPromptText("Kategorie durchsuchen"); // Platzhaltertext

        inputBox.getChildren().addAll(titleField, descriptionField, categoryField, addButton);
        searchBox.getChildren().addAll(searchField, searchButton, resetButton);

        todoListView.setPrefHeight(200);
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    markDoneButton.setDisable(false);
                    removeButton.setDisable(false);
                }
            }
        });

        markDoneButton.setDisable(true);
        removeButton.setDisable(true);

        addButton.setOnAction(e -> addTodo());
        markDoneButton.setOnAction(e -> markTodoAsDone());
        removeButton.setOnAction(e -> removeTodo());
        searchButton.setOnAction(e -> searchTodos()); // Suchfunktion auslösen
        resetButton.setOnAction(e -> updateTodoListView()); // Liste zurücksetzen

        VBox buttonsBox = new VBox(10);
        buttonsBox.getChildren().addAll(markDoneButton, removeButton);
        root.getChildren().addAll(inputBox, searchBox, todoListView, buttonsBox);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> saveTodosToFile()); // Todos speichern
        primaryStage.show();

        loadTodosFromFile();
    }

    private void addTodo() {
        // add to-do function
        String title = titleField.getText();
        String description = descriptionField.getText();
        String category = categoryField.getText();

        if (!title.isEmpty() && !description.isEmpty() && !category.isEmpty()) {
            Todo todo = new Todo(title, description, category);
            todoList.addTodo(todo);
            updateTodoListView();
            clearInputs();
        }
    }

    private void markTodoAsDone() {
        // mark as done function
        String selectedTodo = todoListView.getSelectionModel().getSelectedItem();
        if (selectedTodo != null) {
            for (int i = 0; i < todoList.getTodos().size(); i++) {
                if (todoList.getTodos().get(i).toString().equals(selectedTodo)) {
                    todoList.markAsDone(i);
                    updateTodoListView();
                    break;
                }
            }
        }
    }

    private void removeTodo() {
        // remove to-do function
        String selectedTodo = todoListView.getSelectionModel().getSelectedItem();
        if (selectedTodo != null) {
            for (int i = 0; i < todoList.getTodos().size(); i++) {
                if (todoList.getTodos().get(i).toString().equals(selectedTodo)) {
                    todoList.removeTodo(i);
                    updateTodoListView();
                    break;
                }
            }
        }
    }

    private void searchTodos() {
        // search for to-do function
        String searchCategory = searchField.getText();
        if (!searchCategory.isEmpty()) {
            List<Todo> filteredTodos = todoList.getTodosByCategory(searchCategory);
            todoListView.getItems().clear();
            for (Todo todo : filteredTodos) {
                todoListView.getItems().add(todo.toString());
            }
        }
    }

    private void updateTodoListView() {
        // update to-do view
        todoListView.getItems().clear();
        for (Todo todo : todoList.getTodos()) {
            String todoString = todo.toString();
            if (todo.isDone()) {
                todoString = "✔ " + todoString;
            }
            todoListView.getItems().add(todoString);
        }
    }

    private void clearInputs() {
        // clears all inputs
        titleField.clear();
        descriptionField.clear();
        categoryField.clear();
    }

    private void saveTodosToFile() {
        // saves the changes
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("todos.txt"))) {
            for (Todo todo : todoList.getTodos()) {
                writer.write(todo.getTitle() + "|" + todo.getDescription() + "|" + todo.getCategory() + "|" + todo.isDone());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTodosFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("todos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String title = parts[0];
                    String description = parts[1];
                    String category = parts[2];
                    boolean isDone = Boolean.parseBoolean(parts[3]);
                    Todo todo = new Todo(title, description, category);
                    todo.setDone(isDone);
                    todoList.addTodo(todo);
                }
            }
            updateTodoListView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
