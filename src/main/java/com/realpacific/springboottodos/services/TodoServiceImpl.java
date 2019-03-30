package com.realpacific.springboottodos.services;

import com.realpacific.springboottodos.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static Long idCounter = 0L;

    static {
        todos.add(new Todo(++idCounter, "prashant", "Learn Android", new Date(), true));
        todos.add(new Todo(++idCounter, "prashant", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "prashant", "Learn ML", new Date(), false));
        todos.add(new Todo(++idCounter, "prashant", "Be the greatest", new Date(), true));
    }

    @Override
    public List<Todo> getAll() {
        return todos;
    }

    @Override
    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo != null) {
            todos.remove(todo);
            return todo;
        }
        return null;
    }

    @Override
    public Todo saveTodo(Todo newTodo) {
        if (newTodo.getId() == -1) {
            newTodo.setId(++idCounter);
            todos.add(newTodo);
        } else {
            Todo todo = deleteById(newTodo.getId());
            if (todo != null) {
                todos.add(newTodo);
            }
        }
        return newTodo;
    }
}
