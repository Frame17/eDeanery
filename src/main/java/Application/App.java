package Application;

import Application.model.UserRequest;
import Application.dao.UserRequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRequestRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new UserRequest("Jack", true));
            repository.save(new UserRequest("test1", false));
            repository.save(new UserRequest("test2", false));
            repository.save(new UserRequest("test3", false));

            for (UserRequest userRequest: repository.findByIsAnswered(false)) {
                System.out.println(userRequest);
            }

        };
    }
}
