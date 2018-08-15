package Application.service;

import Application.dao.UserRepository;
import Application.model.User;
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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
    public User findByEmail(String email){return userRepository.findByEmail(email);}
}
