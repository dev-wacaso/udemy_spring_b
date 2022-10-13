package com.isquibly.service;

import com.isquibly.model.Todo;
import com.isquibly.model.TodoData;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoData data = new TodoData();

//    @Autowired
//    public TodoServiceImpl(TodoData data) {
//        this.data = data;
//    }
    @Override
    public void addTodo(@NonNull Todo todo) {
        data.addTodo(todo);
    }

    @Override
    public void removeTodo(int id) {
        data.removeTodo(id);
    }

    @Override
    public Todo getTodo(int id) {
        return data.getTodo(id);
    }

    @Override
    public void updateTodo(@NonNull Todo todo) {
        data.updateTodo(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return data.getTodos();
    }
}
