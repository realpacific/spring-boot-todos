package com.realpacific.springboottodos.controllers;

import com.realpacific.springboottodos.entity.Response;
import com.realpacific.springboottodos.entity.Todo;
import com.realpacific.springboottodos.services.TodoJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoJPAService service;

    @GetMapping("/users/{username}/todos")
    List<Todo> getAll(@PathVariable("username") String username) {
        return service.getAll(username);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("username") String username, @PathVariable("id") long id) {
        Todo todo = service.deleteById(id, username);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/users/{username}/todos/{id}")
    ResponseEntity<Todo> updateTodo(@PathVariable("username") String username, @PathVariable("id") long id,
                                    @RequestBody Todo newTodo) {
        Todo todo = service.saveTodo(newTodo, username);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    ResponseEntity<Void> createNewTodo(@PathVariable("username") String username, @Valid @RequestBody Todo newTodo) {
        Todo todo = service.saveTodo(newTodo, username);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
        System.out.println(uri);
        return ResponseEntity.created(uri).build();
    }


    @GetMapping("/users/{username}/todos/{id}")
    Todo findTodobyId(@PathVariable("username") String username, @PathVariable("id") long id) {
        Todo todo = service.findById(id, username);
        return todo;
    }

    @GetMapping("/basicauth")
    public Response authentication() {
        return new Response("Cool");
    }
}
