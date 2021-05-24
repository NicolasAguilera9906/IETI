package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl  implements UserService {

    private List<User> users = new ArrayList<>();

    @Autowired
    public UserServiceImpl() { }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "nico@mail.com", "nico123", "Nicolas", "Aguilera" ) );
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( Long id )
    {
        return users.get(Math.toIntExact(id));
    }

    @Override
    public User createUser( User user )
    {
        users.add(user);
        return user;
    }

    @Override
    public User findUserByEmail( String email ) throws Exception {
        for(User u : users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        throw new Exception("User not found");
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password ) throws Exception {
        for(User u : users){
            if(u.getEmail().equals(email)){
                if(u.getPassword().equals(password)){
                    return u;
                }
                else{
                    throw new Exception("Invalid password");
                }
            }
        }
        throw new Exception("User not found");
    }
}
