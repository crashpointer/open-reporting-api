package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Role;
import org.crash.reporting.api.model.RoleEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoleRepositoryTest extends AbstractDAOTest {

    @Autowired
    RoleRepository roleRepository;

    @Before
    public void setUp() {
        for (RoleEnum name : RoleEnum.values()) {
            if (!roleRepository.existsByName(name)) {
                Role role = new Role();
                role.setName(name);
                roleRepository.save(role);
            }
        }
    }

    @Test
    public void findByName() {
        for (RoleEnum name : RoleEnum.values()) {
            Optional<Role> role = roleRepository.findByName(name);

            role.ifPresent(r -> {
                assertEquals(name, r.getName());
            });
        }
    }

    @Test
    public void existsByName() {
        for (RoleEnum name : RoleEnum.values()) {
            assertTrue(roleRepository.existsByName(name));
        }
    }

}
