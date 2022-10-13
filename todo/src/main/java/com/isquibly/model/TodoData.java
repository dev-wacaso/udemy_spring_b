package com.isquibly.model;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Component
public class TodoData {
    private static int idValue = 1;
    private final List<Todo> lstTodos = new ArrayList<>();

    public TodoData() {
        _initDummyData();
    }

    private void _initDummyData() {
        addTodo(new Todo("do laundry", "need cleans socks!", LocalDate.now()));
        addTodo(new Todo("get haircut", "hair?! we don't got no stinkin' hair!", LocalDate.now()));
        addTodo(new Todo("go shopping", "out of ketchup", LocalDate.now()));
        addTodo(new Todo("work out", "get thee to the gym", LocalDate.now()));
        addTodo(new Todo("do 5th thing", "complete 5th task", LocalDate.now()));
    }

    public List<Todo> getTodos() {
        return Collections.unmodifiableList(lstTodos);
    }

    public void addTodo(@NonNull Todo todo) {
        todo.setId(idValue++);
        lstTodos.add(todo);
    }

    public void removeTodo(int id)  {
        for (Todo t : lstTodos) {
            if (t.getId() == id) {
                lstTodos.remove(t);
                break;
            }
        }
    }

    public Todo getTodo(int id) {
        for (Todo t: lstTodos) {
            if (t.getId() == id) {
                return t;
            }
        }

        return null;
    }

    public void updateTodo(@NonNull Todo todo) {
        ListIterator<Todo> todoIterator = lstTodos.listIterator();

        Todo tmp;
        while (todoIterator.hasNext()) {
            tmp = todoIterator.next();

            if (tmp.equals(todo)) {
                todoIterator.set(todo);
                break;
            }
        }
    }

}
