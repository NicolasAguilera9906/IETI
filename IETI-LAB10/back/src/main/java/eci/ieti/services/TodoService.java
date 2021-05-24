package eci.ieti.services;

import eci.ieti.data.model.Todo;

import java.util.List;

public interface TodoService {

    public Todo createTodo(Todo todo);
    List<Todo> getTodos();
}
