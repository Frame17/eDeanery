package Application.dao;


import Application.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User save(User user);

    User findByEmail(String email);
}