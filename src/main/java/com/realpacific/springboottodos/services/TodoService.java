package com.realpacific.springboottodos.services;

import com.realpacific.springboottodos.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();

    Todo findById(long id);

    Todo deleteById(long id);

    Todo saveTodo(Todo newTodo);

}
