package co.edu.escuelaing.taskplanner.services;

import co.edu.escuelaing.taskplanner.exceptions.TaskPlannerException;
import co.edu.escuelaing.taskplanner.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final User[] usersMock = {
            new User(1, "nicolas@gmail.com", "Nicolas Aguilera", "nicolas123"),
            new User(2, "aguilera@gmail.com", "Carlos Aguilera", "carlos123"),
            new User(3, "contreras@gmail.com", "Andres Contreras", "andres123")};

    private ArrayList<User> users = new ArrayList<User>(Arrays.asList(usersMock));

    @Override
    public List<User> getAll() throws TaskPlannerException {
        if(users.size()==0){
            throw new TaskPlannerException("There are no users", HttpStatus.NOT_FOUND);
        }
        return users;
    }

    @Override
    public User getById(String userId) throws TaskPlannerException {
        User user = null;
        for(User userFor : users){
            if(userFor.getId() == Integer.parseInt(userId)){
                user  = userFor;
            }
        }
        if(user==null){
            throw new TaskPlannerException("User not found", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    @Override
    public User create(User user) throws TaskPlannerException {
        if(user==null){
            throw new TaskPlannerException("The user can't be null", HttpStatus.BAD_REQUEST);
        }
        users.add(user);
        user.setId(users.size());
        return user;
    }

    @Override
    public User update(User user) throws TaskPlannerException {
        int idUser = -1;
        for(int i=0 ; i<users.size() ; i++){
            if(users.get(i).getId() == user.getId()){
                idUser = i;
            }
        }
        if(idUser == -1){
            throw new TaskPlannerException("User not found" , HttpStatus.NOT_FOUND);
        }
        users.remove(idUser);
        users.add(user);
        user.setId(users.size());
        return user;
    }

    @Override
    public void remove(String userId) throws TaskPlannerException {
        int idUser = Integer.parseInt(userId);
        User user = getById(userId);
        users.remove(user);
    }
}
