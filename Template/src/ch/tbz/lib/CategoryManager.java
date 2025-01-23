package ch.tbz.lib;

import java.util.ArrayList;

import static ch.tbz.lib.Input.inputInt;
import static ch.tbz.lib.Input.inputString;
import static java.lang.System.out;

public class CategoryManager {
    private ArrayList<Category> listedCategories = new ArrayList<>();

    public void addCategory() {
        String name = inputString("Gib den Namen der Category ein");
        String description = inputString("Gib die Beschreibung ein");
        Category category = new Category(name, description);
        listedCategories.add(category);
        TaskManager taskManager = new TaskManager();

    }

    public void editCategory() {
        int editCategory = inputInt("Welche Category möchtest du bearbeiten?");
        String newCategoryValue = inputString("Wie soll der Category nun lauten?");
        //listedCategories.set(editCategory, newCategoryValue);
        System.out.println(listedCategories);
    }

    public void deleteCategory() {
        int deleteCategory = inputInt("Welche Category möchtest du löschen?");
        listedCategories.remove(deleteCategory);
    }

    public String getCategory() {
        if (listedCategories.isEmpty()) {
            return "No categories available.";
        }
        StringBuilder listedCategories = new StringBuilder();
        for (Category category : this.listedCategories) {
            listedCategories.append(category.toString()).append("\n");
        }
        return this.listedCategories.toString();
    }

    public void operations() {
        out.println("Was möchtest du tun?");
        out.println("[1] Category hinzufügen");
        out.println("[2] Category bearbeiten");
        out.println("[3] Category löschen");
        int categoryOptionChoice = inputInt("Gib die Category-Nummer an:");
        if (categoryOptionChoice == 1) {
            addCategory();
        } else if (categoryOptionChoice == 2) {
            editCategory();
        } else if (categoryOptionChoice == 3) {
            deleteCategory();
        }
    }

    public ArrayList<Category> getListedCategories() {
        return listedCategories;
    }
}
