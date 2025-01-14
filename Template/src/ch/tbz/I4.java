package ch.tbz;

import ch.tbz.lib.Category;
import ch.tbz.lib.CategoryManager;
import ch.tbz.lib.Task;
import ch.tbz.lib.TaskManager;

import static ch.tbz.lib.Input.*;
import static java.lang.System.out;

public class I4 {
    public static void main(String[] args) {
        boolean rerunProgram = false;
        TaskManager taskManager = new TaskManager();
        CategoryManager categoryManager = new CategoryManager();

        do {
            out.println("Was möchtest du tun?");
            out.println("[1] Task hinzufügen");
            out.println("[2] Task bearbeiten");
            out.println("[3] Task löschen");

            taskManager.operations();
            categoryManager.operations();

            // After performing an operation, display the current list of tasks
            String tasksList = taskManager.getTasks();
            String categoryList = categoryManager.getCategory();

            out.println("Aktuelle Tasks:");
            out.println(tasksList);

            // Ask the user if they want to perform another operation
            boolean runAgain = inputBoolean("Neue Operation?");
            rerunProgram = runAgain;
        } while (rerunProgram);
    }
}