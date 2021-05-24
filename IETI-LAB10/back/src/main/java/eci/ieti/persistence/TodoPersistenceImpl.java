package eci.ieti.persistence;

import eci.ieti.data.TodoRepository;
import eci.ieti.data.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoPersistenceImpl implements TodoPersistence {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos;
    }
}
