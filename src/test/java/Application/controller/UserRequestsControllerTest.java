package Application.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRequestsControllerTest {

    private ResponseEntity<String> responseEntity;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getUserPage() throws Exception {
        responseEntity = testRestTemplate.getForEntity("/userPage", String.class);
        assertTrue("Could not find /userPage page", responseEntity.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void getAddForm() throws Exception {
        responseEntity = testRestTemplate.getForEntity("/add", String.class);
        assertTrue("Could not find /add page", responseEntity.getStatusCode().is2xxSuccessful());
    }
}