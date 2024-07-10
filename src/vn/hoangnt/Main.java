package vn.hoangnt;
import java.util.*;

public class Main {
    private static TodoManager todoManager = new TodoManager();
    private static TodoFileManager fileManager = new TodoFileManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        todoManager.setTodos(fileManager.loadTodos());

        while (true) {
            displayMainMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    createTodo();
                    break;
                case "2":
                    editTodo();
                    break;
                case "3":
                    finishTodo();
                    break;
                case "4":
                    deleteTodo();
                    break;
                case "5":
                    fileManager.saveTodos(todoManager.getTodos());
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("Welcome!");
        long count = todoManager.Count();

        if (count == 0) {
            System.out.println("You have no more TODOs left!!!");
        } else if (count == 1) {
            System.out.println("You have 1 TODO left.");
        } else {
            System.out.println("You have " + count + " TODOs left.");
        }

        int id = 1;
        for (Todo todo : todoManager.getTodos()) {
            if (todo.getUntilDate().compareTo(new Date()) >= 0) {
                System.out.printf("%d. %s %s%n", id, todo.getTitle(), todo.isDone() ? "(Done)" : "");
                id++;
            }
        }

        System.out.println();

        System.out.println("1. Create TODO");
        System.out.println("2. Edit TODO");
        System.out.println("3. Finish TODO");
        System.out.println("4. Delete TODO");
        System.out.println("5. Exit");
        System.out.print("Input: ");
    }

    private static void createTodo() {
        String title;
        Date untilDate = null;

        while (true) {
            System.out.print("Title: ");
            title = scanner.nextLine().trim();

            System.out.print("Until: ");
            String until = scanner.nextLine().trim();

            try {
                untilDate = Todo.parseDate(until);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        todoManager.addTodo(title, untilDate);
        fileManager.saveTodos(todoManager.getTodos());
        System.out.println("Saved!!!");
    }

    private static void editTodo() {
        int id;

        while (true) {
            System.out.print("Edit TODO number: ");
            id = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (id >= 0 && id < todoManager.getTodos().size()) {
                break;
            } else {
                System.out.println("Invalid TODO number!");
            }
        }

        String title = null;
        Date untilDate = null;

        while (true) {
            System.out.print("Title: ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                title = input;
            }

            System.out.print("Until : ");
            String until = scanner.nextLine().trim();

            try {
                untilDate = until.isEmpty() ? null : Todo.parseDate(until);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        todoManager.editTodo(id, title, untilDate);
        fileManager.saveTodos(todoManager.getTodos());
        System.out.println("Saved!!!");
    }

    private static void finishTodo() {
        int id;

        while (true) {
            System.out.print("Finish TODO number: ");
            id = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (id >= 0 && id < todoManager.getTodos().size()) {
                break;
            } else {
                System.out.println("Invalid TODO number!");
            }
        }

        todoManager.finishTodo(id);
        fileManager.saveTodos(todoManager.getTodos());
    }

    private static void deleteTodo() {
        int id;

        while (true) {
            System.out.print("Delete TODO number: ");
            id = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (id >= 0 && id < todoManager.getTodos().size()) {
                break;
            } else {
                System.out.println("Invalid TODO number!");
            }
        }

        todoManager.deleteTodo(id);
        fileManager.saveTodos(todoManager.getTodos());
    }
}
