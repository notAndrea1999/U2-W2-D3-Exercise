package andreademasi.U2W2D3Exercise.runner;

import andreademasi.U2W2D3Exercise.services.BlogService;
import andreademasi.U2W2D3Exercise.services.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BlogRunner implements CommandLineRunner {
    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random rndm = new Random();
//        for (int i = 0; i < 10; i++) {
//            User foundUser = userService.findAuthorById(rndm.nextLong(1, 11));
//            blogService.save(new Blog(faker.book().genre(),
//                    faker.book().title(), faker.medical().symptoms(),
//                    faker.medical().hospitalName(),
//                    rndm.nextInt(1, 100),
//                    foundUser));
//
//        }
    }
}
