package Application.service;

import Application.dao.UserRequestRepository;
import Application.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Doubling methods here to use them in @Controller and easily implement other requirements to information from DB
 */

@Service
public class RequestService {

    private final UserRequestRepository userRequestRepository;

    @Autowired
    public RequestService(UserRequestRepository userRequestRepository) {
        this.userRequestRepository = userRequestRepository;
    }

    public List<UserRequest> findAll() {
        return userRequestRepository.findAll();
    }

    public List<UserRequest> findAllByResponseTextNull() {
        return userRequestRepository.findAllByResponseTextNull();
    }

    public void save(UserRequest userRequest) {
        userRequestRepository.save(userRequest);
    }

    public UserRequest findUserRequestById(long id) {
        return userRequestRepository.findById(id);
    }

    public void updateUserRequestById(long id, String responseText) {
        userRequestRepository.updateRequestById(id, responseText);
    }

    public void deleteUserRequestById(long id) {
        userRequestRepository.deleteById(id);
    }
}
