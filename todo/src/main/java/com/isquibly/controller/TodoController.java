package com.isquibly.controller;

import com.isquibly.model.Todo;
import com.isquibly.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public final class TodoController {

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
        return RenderViewNames.LIST_TODOS;
    }

    @GetMapping(RequestMappings.GET_TODO)
    public String getTodo(@RequestParam int id, Model model) {
        Todo todo = todoService.getTodo(id);
        model.addAttribute(ModelAttributeKeys.TODO, todo);
        return RenderViewNames.VIEW_TODO;
    }

    @GetMapping(RequestMappings.ADD_EDIT_TODO)
    public String addEditTodo(@RequestParam(required = false, defaultValue="-1") int id, Model model) {
        Todo todo = todoService.getTodo(id);
        if (todo == null){
            todo = Todo.blank();
        }
        model.addAttribute(ModelAttributeKeys.TODO, todo);
        return RenderViewNames.ADD_EDIT_TODO;
    }

    @PostMapping(RequestMappings.ADD_EDIT_TODO)
    String handleSubmission(@ModelAttribute(ModelAttributeKeys.TODO) Todo todo) {
        log.info("processItem() data from form: {}", todo);
        if (todo.getId() > 0) {
            todoService.updateTodo(todo);
        }
        else {
            todoService.addTodo(todo);
        }
        return "redirect:/" + RequestMappings.LIST_TODOS;
    }

    @GetMapping(RequestMappings.DELETE_TODO)
//    public String deleteTodo(@ModelAttribute(ModelAttributeKeys.ID) int id) {
    public String deleteTodo(@RequestParam int id) {
        log.info("deleteTodo(), removing Todo({}) ", id);
        todoService.removeTodo(id);
        return "redirect:/" + RequestMappings.LIST_TODOS;
    }

}
