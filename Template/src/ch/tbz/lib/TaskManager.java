package ch.tbz.lib;

import java.util.ArrayList;

import static ch.tbz.lib.Input.inputInt;
import static ch.tbz.lib.Input.inputString;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask() {
        String name = inputString("Gib den Namen des Tasks ein");
        String description = inputString("Gib die Beschreibung ein");
        int priority = inputInt("Gib einer Priority des Tasks");
        Task task = new Task(name, description, priority);
        tasks.add(task);
    }

    public void editTask() {
        int editTask = inputInt("Welchen Task möchtest du bearbeiten?");
        String newTaskValue = inputString("Wie soll der Task nun lauten?");
        //tasks.set(editTask, newTaskValue);
        System.out.println(tasks);
    }

    public void deleteTask() {
        int deleteTask = inputInt("Welchen Task möchtest du löschen?");
        tasks.remove(deleteTask);
    }

    public String getTasks() {
        if (tasks.isEmpty()) {
            return "No tasks available.";
        }
        StringBuilder taskList = new StringBuilder();
        for (Task task : tasks) {
            taskList.append(task.toString()).append("\n");
        }
        return taskList.toString();
    }

    public void operations() {
        int taskOptionChoice = inputInt("Gib die Task-Nummer an:");
        if (taskOptionChoice == 1) {
            addTask();
        } else if (taskOptionChoice == 2) {
            editTask();
        } else if (taskOptionChoice == 3) {
            deleteTask();
        }
    }

    public ArrayList<Task> getTaskList() {
        return tasks;
    }
}
