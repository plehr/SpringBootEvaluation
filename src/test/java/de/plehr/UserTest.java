package de.plehr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_return_user_by_id() {

        long id = 0;
        String[] names = { "Hans", "Peter", "Giesela" };
        for (String s : names) {
            User us = new User();
            us.setId(id++);
            us.setName(s);
            userRepository.save(us);
        }

        assertThat(((User)userRepository.findById(0).get(0)).getName()).isEqualTo("Hans");
    }

    @Test
    public void should_return_user_by_name() {
        long id=0;
        String[] names = {"Hans","Peter","Giesela"};
        for (String s : names) {
            User us = new User();
            us.setId(id++);
            us.setName(s);
            userRepository.save(us);
        }

        assertThat(((User) userRepository.findByName("Peter").get(0)).getId()).isEqualTo(1);
    }

    @Test
    public void should_return_null_if_not_exists() {
        long id = 0;
        String[] names = { "Hans", "Peter", "Giesela" };
        for (String s : names) {
            User us = new User();
            us.setId(id++);
            us.setName(s);
            userRepository.save(us);
        }

        assertThat(userRepository.findByName("Marie")).isEmpty();
    }
}