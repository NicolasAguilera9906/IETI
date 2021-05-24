package co.edu.escuelaing.taskplanner.services;

import co.edu.escuelaing.taskplanner.exceptions.TaskPlannerException;
import co.edu.escuelaing.taskplanner.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAll() throws TaskPlannerException;

    User getById(String userId) throws TaskPlannerException;

    User create(User user) throws TaskPlannerException;

    User update(User user) throws TaskPlannerException;

    void remove(String userId) throws TaskPlannerException;
}
