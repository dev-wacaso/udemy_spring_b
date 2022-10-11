package com.isquibly.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class TodoData {
    private static int idValue = 1;
    private final List<Todo> items = new ArrayList<>();

    public TodoData() {
        _initDummyData();
    }

    private void _initDummyData() {
        addItem(new Todo("do laundry", "need cleans socks!", LocalDate.now()));
        addItem(new Todo("get haircut", "hair?! we don't got no stinkin' hair!", LocalDate.now()));
        addItem(new Todo("go shopping", "out of ketchup", LocalDate.now()));
        addItem(new Todo("work out", "get thee to the gym", LocalDate.now()));
    }

    public List<Todo> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull Todo todo) {
        todo.setId(idValue++);
        items.add(todo);
    }

    public void remoteItem(int id)  {
        for (Todo t : items) {
            if (t.getId() == id) {
                items.remove(t);
                break;
            }
        }
    }

    public Todo getItem(int id) {
        for (Todo t: items) {
            if (t.getId() == id) {
                return t;
            }
        }

        return null;
    }

    public void updateItem(@NonNull Todo item) {
        ListIterator<Todo> todoIterator = items.listIterator();

        Todo tmp;
        while (todoIterator.hasNext()) {
            tmp = todoIterator.next();

            if (tmp.equals(item)) {
                todoIterator.set(item);
                break;
            }
        }
    }

}
