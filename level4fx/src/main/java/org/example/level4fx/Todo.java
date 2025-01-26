package org.example.level4fx;


public class Todo {
    private String title;
    private String description;
    private boolean isDone;
    private String category;

    public Todo(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.isDone = false;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return title + " (" + category + ") - " + (isDone ? "Erledigt" : "Offen");
    }
}