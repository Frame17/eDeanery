package Application.dao;

import Application.model.UserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
//todo code refactoring, adding @Before and @BeforeAll methods
@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRequestRepositoryTest {

    @Autowired
    private UserRequestRepository userRequestRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAll() {
        List<UserRequest> userRequests = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            userRequests.add(entityManager.persistFlushFind
                    (new UserRequest("testText" + i, "testTopic" + i)));
        userRequests.forEach(System.out::println);
        assertThat(userRequests).isEqualTo(userRequestRepository.findAll());
    }

    @Test
    public void findById() {
        UserRequest userRequest = entityManager.persistFlushFind
                (new UserRequest("testText", " testTopic"));
        assertThat(userRequest).isEqualTo(userRequestRepository.findById(1));
    }

    @Test
    public void findAllByResponseTextNull() {
        List<UserRequest> userRequests = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            userRequests.add(entityManager.persistFlushFind
                    (new UserRequest("testText" + i, "testTopic" + i)));
        UserRequest answeredUserRequest = new UserRequest("answered", "answered");
        answeredUserRequest.setResponseText("answer");
        entityManager.persistAndFlush(answeredUserRequest);
        assertThat(userRequestRepository.findAllByResponseTextNull()).isEqualTo(userRequests);
    }

    @Test
    public void updateRequestById() {
        long id = (long) entityManager.persistAndGetId
                (new UserRequest("testText", " testTopic"));
        userRequestRepository.updateRequestById(id, "answer");
        entityManager.refresh(entityManager.find(UserRequest.class, id));
        assertThat(entityManager.find(UserRequest.class, id).getResponseText()).isNotNull();
    }

    @Test
    public void deleteById() {
        long id = (long) entityManager.persistAndGetId
                (new UserRequest("testText", " testTopic"));
        userRequestRepository.deleteById(id);
        assertThat(entityManager.find(UserRequest.class, id)).isNull();
    }

    @Test
    public void save() {
        userRequestRepository.save(new UserRequest("testText", "testTopic"));
        System.out.println(entityManager.find(UserRequest.class, (long) 1));
        assertThat(entityManager.find(UserRequest.class, (long) 1)).isNotNull();
    }
}