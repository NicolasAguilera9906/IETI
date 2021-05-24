package eci.ieti.services;


import eci.ieti.data.model.Todo;
import eci.ieti.persistence.TodoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {


    @Autowired
    TodoPersistence todoPersistence;
    @Override
    public Todo createTodo(Todo todo) {
        todoPersistence.createTodo(todo);
        return todo;
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = todoPersistence.getTodos();
        return todos;
    }
}
