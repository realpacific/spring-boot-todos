package com.realpacific.springboottodos.services;

import com.realpacific.springboottodos.TodoJPARepository;
import com.realpacific.springboottodos.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoJPAServiceImpl implements TodoJPAService {
    @Autowired
    TodoJPARepository repo;

    @Override
    public List<Todo> getAll(String username) {
        return repo.findAllByUsername(username);
    }

    @Override
    public Todo findById(long id, String username) {
        return repo.getOne(id);
    }

    @Override
    public Todo deleteById(long id, String username) {
        Todo todo = repo.getOne(id);
        repo.deleteById(id);
        return todo;
    }

    @Override
    public Todo saveTodo(Todo newTodo, String username) {
        newTodo.setUsername(username);
        return repo.save(newTodo);
    }
}
