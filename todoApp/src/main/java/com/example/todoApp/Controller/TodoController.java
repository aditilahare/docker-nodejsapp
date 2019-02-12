package com.example.todoApp.Controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class TodoController {

    private String getTodos() throws IOException {
        Stream<String> todos = Files.lines(Paths.get("./todo.json"), StandardCharsets.UTF_8);
        return todos.collect(Collectors.joining(""));
    }

    @GetMapping(value = "/todos")
    public Object showTodos() throws IOException {
        return getTodos();
    }

    @PostMapping(value = "/todos")
    public String addTodos(@RequestBody Object currentTodo) throws IOException, JSONException {
        JSONArray existingTodos = new JSONArray(getTodos());
        existingTodos.put(currentTodo);
        Files.write(Paths.get("./todo.json"), Collections.singleton(existingTodos.toString()));
        return currentTodo.toString();
    }
}