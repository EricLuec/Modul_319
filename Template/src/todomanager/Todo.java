package todomanager;

public class Todo {
    private String title;
    private String description;
    private boolean isDone;
    private String category; // Neue Eigenschaft für die Kategorie

    // Konstruktor
    public Todo(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.isDone = false;
        this.category = category;
    }

    // Getter und Setter für Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter und Setter für Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter und Setter für isDone
    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    // Getter und Setter für Category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                ", category='" + category + '\'' +
                '}';
    }
}
