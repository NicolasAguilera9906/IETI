package eci.ieti.persistence;

import eci.ieti.data.model.Todo;

import java.util.List;

public interface TodoPersistence {

    public Todo createTodo(Todo todo);

    List<Todo> getTodos();

}
