package eci.ieti.controller;

import eci.ieti.data.model.Todo;
import eci.ieti.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/" )
public class TodoController
{

    @Autowired
    private TodoService todoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/todos", method = RequestMethod.POST )
    public Todo addTask(@RequestBody Todo todo ) throws Exception {
        todoService.createTodo(todo);
        return todo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/todos", method = RequestMethod.GET )
    public List<Todo> getTasks() throws Exception {
        List<Todo> todo = todoService.getTodos();
        return todo;
    }

}
