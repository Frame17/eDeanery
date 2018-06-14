package Application.dao;


import Application.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Long> {

    List<Users> findAll();

    Users save(Users user);

}