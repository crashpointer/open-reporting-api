package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Merchant;
import org.crash.reporting.api.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.Assert.*;

public class MerchantRepositoryTest extends AbstractDAOTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MerchantRepository merchantRepository;

    private static final String name = "Dev Merchant";

    private static final String userName = "Open Source";

    private static final String userUsername = "opensource";

    private static final String userEmail = "opensource@crash.org";

    private static final String password = "freeBSD";

    @Before
    public void setUp() {
        if (!merchantRepository.existsByName(name)) {
            Merchant merchant = new Merchant();
            merchant.setName(name);

            if (!userRepository.existsByEmail(userEmail)) {
                User user = new User();
                user.setName(userName);
                user.setUsername(userUsername);
                user.setEmail(userEmail);
                user.setPassword(passwordEncoder.encode(password));
                merchant.setUser(userRepository.save(user));
            } else {
                Optional<User> user = userRepository.findByEmail(userEmail);
                user.ifPresent(merchant::setUser);
            }

            merchantRepository.save(merchant);
        }
    }

    @Test
    public void findByName() {
        Optional<Merchant> merchant = merchantRepository.findByName(name);

        merchant.ifPresent(m -> {
            assertTrue(m.getId() > 0);
            assertEquals(name, m.getName());
            assertTrue(m.getUser().getId() > 0);
            assertEquals(userEmail, m.getUser().getEmail());
        });
    }

    @Test
    public void findByUser() {
        Optional<User> user = userRepository.findByEmail(userEmail);

        assert user.isPresent();
        Optional<Merchant> merchant = merchantRepository.findByUser(user.get());
        merchant.ifPresent(m -> {
            assertTrue(m.getId() > 0);
            assertTrue(m.getUser().getId() > 0);
            assertEquals(user.get().getId(), m.getUser().getId());
        });
    }

    @Test
    public void existsByName() {
        assertTrue(merchantRepository.existsByName(name));
    }

}
