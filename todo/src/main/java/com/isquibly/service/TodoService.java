package com.isquibly.service;

import com.isquibly.model.Todo;

import java.util.List;

public interface TodoService {
    public void addTodo(Todo todo);
    public void removeTodo(int id);
    public Todo getTodo(int id);
    public void updateTodo(Todo todo);
    public List<Todo> getTodos();
}
