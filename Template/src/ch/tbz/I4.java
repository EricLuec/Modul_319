package ch.tbz;

import ch.tbz.lib.CategoryManager;

import static ch.tbz.lib.Input.*;
import static java.lang.System.out;

public class I4 {

    public static void main(String[] args) {
        boolean rerunProgram = false;
        CategoryManager categoryManager = new CategoryManager();

        categoryManager.operations();
        String categoryList = categoryManager.getCategory();
        do {
            out.println("Aktuelle Categories:");
            out.println(categoryList);
            inputInt("Select a category: ");
            out.println(categoryManager.);

            boolean runAgain = inputBoolean("Neue Operation?");
            rerunProgram = runAgain;
        } while (rerunProgram);
    }
}