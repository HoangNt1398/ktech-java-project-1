package vn.hoangnt;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class TodoFileManager {
    private static final String TODO_FILE_NAME = "todos.txt";

    public List<Todo> loadTodos() {
        try {
            return Files.lines(Paths.get(TODO_FILE_NAME))
                    .map(Todo::fromSting)
                    .collect(Collectors.toList());
        }catch(IOException e) {
            return new ArrayList<>();
        }
    }

    public void saveTodos(List<Todo> todos) {
        try {
            Files.write(Paths.get(TODO_FILE_NAME),
                    todos.stream()
                            .map(Todo::toString)
                            .collect(Collectors.toList()));
        } catch (IOException e) {
             e.printStackTrace();
        }
    }
}
