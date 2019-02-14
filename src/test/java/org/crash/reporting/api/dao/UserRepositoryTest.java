package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserRepositoryTest extends AbstractDAOTest {

    private static final String name = "Open Source";

    private static final String username = "opensource";

    private static final String email = "opensource@crash.org";

    private static final String password = "freeBSD";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        if(!userRepository.existsByEmail(email)) {
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        }
    }

    @Test
    public void findByEmail() {
        Optional<User> user = userRepository.findByEmail(email);

        assert user.isPresent();
        assertEquals(name, user.get().getName());
        assertEquals(username, user.get().getUsername());
    }

    @Test
    public void findByUsername() {
        Optional<User> user = userRepository.findByUsername(username);

        assert user.isPresent();
        assertEquals(name, user.get().getName());
        assertEquals(email, user.get().getEmail());
    }

    @Test
    public void existsByEmail() {
        assertTrue(userRepository.existsByEmail(email));
    }

    @Test
    public void existsByUsername() {
        assertTrue(userRepository.existsByUsername(username));
    }

}
