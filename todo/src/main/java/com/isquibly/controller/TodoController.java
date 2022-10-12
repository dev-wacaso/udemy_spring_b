package com.isquibly.controller;

import com.isquibly.model.TodoData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoController {
    ///////////
    // Datum //
    ///////////

    @ModelAttribute
    public TodoData toData() {
        return new TodoData();
    }

    ///////////
    // Views //
    ///////////

    // http://localhost:68/todo/items
    // @Bean ViewResolver will return "../path/list_todos.jsp"
    @GetMapping(RequestMappings.LIST_TODOS)
    String handleGetItems() {
        return ViewNames.LIST_TODOS;
    }


}
