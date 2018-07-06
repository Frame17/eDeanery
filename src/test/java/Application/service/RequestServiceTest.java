package Application.service;

import Application.dao.UserRequestRepository;
import Application.model.UserRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RequestServiceTest {
    private UserRequest testUserRequest = new UserRequest("test", "test");

    @Mock
    private RequestService requestService;

    @MockBean
    private UserRequestRepository userRequestRepository;

    @Before
    public void setUp() {
        requestService.findAll();
        requestService.findAllByResponseTextNull();
        requestService.save(testUserRequest);
        requestService.findUserRequestById(testUserRequest.getId());
        requestService.updateUserRequestById(testUserRequest.getId(), "test");
    }

    @Test
    public void findAll() {
        verify(requestService).findAll();
    }

    @Test
    public void findAllByResponseTextNull() {
        verify(requestService).findAllByResponseTextNull();
    }

    @Test
    public void save() {
        verify(requestService).save(testUserRequest);
    }

    @Test
    public void findUserRequestById() {
        verify(requestService).findUserRequestById(testUserRequest.getId());
    }

    @Test
    public void updateUserRequestById() {
        verify(requestService).updateUserRequestById(testUserRequest.getId(), "test");
    }
}