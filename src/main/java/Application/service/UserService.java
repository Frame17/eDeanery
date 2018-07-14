package Application.service;

import Application.dao.UserRepository;
import Application.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Doubling methods here to use them in @Controller and easily implement other requirements to information from DB
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public void save(Users user) {
        userRepository.save(user);
    }
    public Users findByEmail(String email){return userRepository.findByEmail(email);}
}
