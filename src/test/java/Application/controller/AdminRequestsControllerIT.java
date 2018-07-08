package Application.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdminRequestsControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAdminPage(){
        ResponseEntity<String> stringResponseEntity = testRestTemplate.getForEntity("/admin", String.class);
        System.out.println(stringResponseEntity);
    }
}