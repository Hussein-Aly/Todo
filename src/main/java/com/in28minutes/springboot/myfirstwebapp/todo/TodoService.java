package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount, "in28minutes", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "in28minutes", "Learn SQL",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todoCount, "in28minutes", "Learn Spring",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
    public void addTodo(String username, String description, LocalDate targetDate, Boolean done) {
        Todo todo = new Todo(++todoCount, username, description, targetDate, done);
        todos.add(todo);
    }
    public void deleteTodoById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
        todoCount--;
    }

    public Todo findTodoById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo){
        deleteTodoById(todo.getId());
        todos.add(todo);
    }
}
