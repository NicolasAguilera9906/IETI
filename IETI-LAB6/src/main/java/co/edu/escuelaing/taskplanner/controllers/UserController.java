package co.edu.escuelaing.taskplanner.controllers;


import co.edu.escuelaing.taskplanner.exceptions.TaskPlannerException;
import co.edu.escuelaing.taskplanner.model.User;
import co.edu.escuelaing.taskplanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    ResponseEntity<?> getGreeting() throws TaskPlannerException {
        return new ResponseEntity<>("Hello!", HttpStatus.ACCEPTED);

    }

    @GetMapping("/users")
    ResponseEntity<?> getAllUsers() throws TaskPlannerException {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);

    }

    @PostMapping("/users")
    ResponseEntity<?> newUser(@RequestBody User newUser) throws TaskPlannerException {
        return new ResponseEntity<>(userService.create(newUser), HttpStatus.CREATED);
    }


    @GetMapping("/users/{id}")
    ResponseEntity<?> getUserById(@PathVariable String id) throws TaskPlannerException {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/users/{id}")
    ResponseEntity<?> updateUser(@RequestBody User user ,  @PathVariable String id) throws TaskPlannerException {
        user.setId(Integer.parseInt(id));
        return new ResponseEntity<>(userService.update(user), HttpStatus.CREATED);

    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteUser(@PathVariable String id) throws TaskPlannerException {
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}