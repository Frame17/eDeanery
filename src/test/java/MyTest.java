import Application.App;
import Application.controller.UserRequestsController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class MyTest {

    @Autowired
    private UserRequestsController userRequestsController;

    @Test
    public void myTest() {
        assertThat(userRequestsController).isNotNull();
    }
}
