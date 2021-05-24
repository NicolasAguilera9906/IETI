package eci.ieti.services;


import eci.ieti.data.model.User;

import java.util.List;


public interface UserService
{
    List<User> getUsers();

    User getUser( Long id );

    User createUser( User user );

    User findUserByEmail( String email ) throws Exception;

    User findUserByEmailAndPassword( String email, String password ) throws Exception;
}