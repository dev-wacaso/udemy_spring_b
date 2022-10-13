package com.isquibly.controller;

import com.isquibly.model.Todo;
import com.isquibly.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    ///////////
    // Datum //
    ///////////

//    @ModelAttribute
//    public TodoData todoData() {
//        return new TodoData();
//    }

    @ModelAttribute
    public TodoService todoService() {
        return todoService;
    }

    ///////////
    // Views //
    ///////////

    // http://localhost:68/todo/items
    // @Bean ViewResolver will return "../path/list_todos.jsp"
    @GetMapping(RequestMappings.LIST_TODOS)
    String handleGetTodos() {
        return ViewNames.LIST_TODOS;
    }

    @PostMapping(RequestMappings.EDIT_TODO)
    String handleEditTodo(@ModelAttribute Todo todo) {
//        return ViewNames.EDIT_TODO;
        return "redirect:/" + RequestMappings.LIST_TODOS;
    }
}
