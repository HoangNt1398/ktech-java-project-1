package vn.hoangnt;
import java.io.*;
import java.util.*;

public class TodoManager {
    private List<Todo> todos = new ArrayList<>();

    public void addTodo (String title, Date untilDate) {
        todos.add(new Todo(title, untilDate));
    }

    public void editTodo (int id, String title, Date untilDate) {
        if (id >= 0 && id < todos.size()) {
            Todo todo = todos.get(id);
            if (!title.isEmpty()) {
                todo.setTitle(title);
            }
            if (untilDate != null) {
                todo.setUntilDate(untilDate);
            }
        }
    }

    public void finishTodo (int id) {
        if (id >= 0 && id < todos.size()) {
            todos.get(id).setDone(true);
        }
    }

    public void deleteTodo (int id) {
        if (id >=0 && id < todos.size()) {
            todos.remove(id);
        }
    }

    public List<Todo> getTodos() {
        return todos;
    }
    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public long Count () {
        return todos.stream().filter(todo -> !todo.isDone()).count();
    }
}
