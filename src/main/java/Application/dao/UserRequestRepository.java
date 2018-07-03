package Application.dao;

import Application.model.UserRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRequestRepository extends CrudRepository<UserRequest, Long> {

    List<UserRequest> findAll();

    List<UserRequest> findAllByResponseTextNull();

    UserRequest save(UserRequest userRequest);

    UserRequest findById(long id);

}
