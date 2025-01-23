package com.todomanager;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private TodoList todoList = new TodoList();
    private ListView<String> todoListView = new ListView<>();
    private TextField titleField = new TextField();
    private TextField descriptionField = new TextField();
    private TextField categoryField = new TextField();
    private Button addButton = new Button("Todo hinzufügen");
    private Button markDoneButton = new Button("Markieren als erledigt");
    private Button removeButton = new Button("Todo entfernen");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Fenstername
        primaryStage.setTitle("Todo Manager");

        // Layouts
        VBox root = new VBox(10);
        HBox inputBox = new HBox(10);

        // Setup der Eingabefelder und Buttons
        titleField.setPromptText("Titel");
        descriptionField.setPromptText("Beschreibung");
        categoryField.setPromptText("Kategorie");

        inputBox.getChildren().addAll(titleField, descriptionField, categoryField, addButton);

        // ListView zur Anzeige der Todos
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

        // Buttons
        markDoneButton.setDisable(true);
        removeButton.setDisable(true);

        addButton.setOnAction(e -> addTodo());
        markDoneButton.setOnAction(e -> markTodoAsDone());
        removeButton.setOnAction(e -> removeTodo());

        // Layout zusammenbauen
        VBox buttonsBox = new VBox(10);
        buttonsBox.getChildren().addAll(markDoneButton, removeButton);
        root.getChildren().addAll(inputBox, todoListView, buttonsBox);

        // Setzen der Szene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addTodo() {
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
        String selectedTodo = todoListView.getSelectionModel().getSelectedItem();
        if (selectedTodo != null) {
            // Wir finden das Todo-Objekt basierend auf der Anzeige im ListView
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
        String selectedTodo = todoListView.getSelectionModel().getSelectedItem();
        if (selectedTodo != null) {
            // Wir finden das Todo-Objekt basierend auf der Anzeige im ListView
            for (int i = 0; i < todoList.getTodos().size(); i++) {
                if (todoList.getTodos().get(i).toString().equals(selectedTodo)) {
                    todoList.removeTodo(i);
                    updateTodoListView();
                    break;
                }
            }
        }
    }

    private void updateTodoListView() {
        // Die ListView wird mit den Todos aktualisiert
        todoListView.getItems().clear();
        for (Todo todo : todoList.getTodos()) {
            todoListView.getItems().add(todo.toString());
        }
    }

    private void clearInputs() {
        titleField.clear();
        descriptionField.clear();
        categoryField.clear();
    }
}