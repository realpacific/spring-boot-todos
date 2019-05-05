package com.realpacific.springboottodos.services;

import com.realpacific.springboottodos.entity.Todo;

import java.util.List;

public interface TodoJPAService {
    List<Todo> getAll(String username);

    Todo findById(long id, String username);

    Todo deleteById(long id, String username);

    Todo saveTodo(Todo newTodo, String username);
}
