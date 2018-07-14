package Application.dao;

import Application.model.UserRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRequestRepository extends CrudRepository<UserRequest, Long> {

    List<UserRequest> findAll();

    List<UserRequest> findAllByResponseTextNull();

    UserRequest save(UserRequest userRequest);

    UserRequest findById(long id);

    @Transactional
    @Modifying
    @Query("update UserRequest u set u.responseText = :responseText where u.id = :id")
    void updateRequestById(@Param("id") long id, @Param("responseText") String responseText);

    void deleteById(long id);

}
