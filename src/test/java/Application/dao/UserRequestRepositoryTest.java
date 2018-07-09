package Application.dao;

import Application.model.UserRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRequestRepositoryTest {

    @Autowired
    private UserRequestRepository userRequestRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUp() {

    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAllByResponseTextNull() {
    }

    @Test
    public void save() {
        UserRequest userRequest = entityManager.persistAndFlush
                (new UserRequest("testText", "testTopic"));
        assertThat(userRequest.getText()).isEqualTo("testText");
        assertThat(userRequest.getRequestTopic()).isEqualTo("testTopic");
    }

    @Test
    public void findById() {

    }

    @Test
    public void updateRequestById() {
    }

    @Test
    public void deleteById() {
    }
}