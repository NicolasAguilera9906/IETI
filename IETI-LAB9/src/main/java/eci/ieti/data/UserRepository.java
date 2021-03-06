package eci.ieti.data;

import eci.ieti.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String name);

    User findByEmail(String Email);

}