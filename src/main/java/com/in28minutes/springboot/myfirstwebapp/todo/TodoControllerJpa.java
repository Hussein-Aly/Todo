package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private TodoService todoService;

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository)
    {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUsername();
        List<Todo> todos = todoRepository.findByName(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    private static String getLoggedInUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        Todo todo = new Todo(0, getLoggedInUsername(), "Default Description",
                LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername();
        todo.setName(username);
        todoRepository.save(todo);

        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        Todo todo = todoRepository.findById(id).get();
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String UpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername();
        todo.setName(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
}
