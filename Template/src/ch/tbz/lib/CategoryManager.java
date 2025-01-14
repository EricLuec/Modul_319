package ch.tbz.lib;

import java.util.ArrayList;

import static ch.tbz.lib.Input.inputInt;
import static ch.tbz.lib.Input.inputString;

public class CategoryManager {
    private ArrayList<Category> categoryList = new ArrayList<>();

    public void addCategory() {
        String name = inputString("Gib den Namen des Tasks ein");
        String description = inputString("Gib die Beschreibung ein");
        Category category = new Category(name, description);
        categoryList.add(category);
    }

    public void editCategory() {
        int editCategory = inputInt("Welche Category möchtest du bearbeiten?");
        String newCategoryValue = inputString("Wie soll der Category nun lauten?");
        //tasks.set(editTask, newTaskValue);
        System.out.println(categoryList);
    }

    public void deleteCategory() {
        int deleteCategory = inputInt("Welche Category möchtest du löschen?");
        categoryList.remove(deleteCategory);
    }

    public String getCategory() {
        if (categoryList.isEmpty()) {
            return "No tasks available.";
        }
        StringBuilder categoryList = new StringBuilder();
        for (Category category : categoryList) {
            categoryList.append(category.toString()).append("\n");
        }
        return categoryList.toString();
    }

    public void operations() {
        int categoryOptionChoice = inputInt("Gib die Category-Nummer an:");
        if (categoryOptionChoice == 1) {
            addCategory();
        } else if (categoryOptionChoice == 2) {
            editCategory();
        } else if (categoryOptionChoice == 3) {
            deleteCategory();
        }
    }

    public ArrayList<Task> getCategoryList() {
        return categoryList;
    }
}
