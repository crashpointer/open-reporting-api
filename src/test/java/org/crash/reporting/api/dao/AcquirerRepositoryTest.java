package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Acquirer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AcquirerRepositoryTest extends AbstractDAOTest {

    @Autowired
    AcquirerRepository acquirerRepository;

    private static final String name = "Morgan Bank";

    private static final String code = "MB";

    @Before
    public void setUp() {
        if (!acquirerRepository.existsByCode(code)) {
            Acquirer acquirer = new Acquirer();
            acquirer.setName(name);
            acquirer.setCode(code);
            acquirerRepository.save(acquirer);
        }
    }

    @Test
    public void findByName() {
        Optional<Acquirer> acquirer = acquirerRepository.findByName(name);

        acquirer.ifPresent(a -> {
            assertTrue(a.getId() > 0);
            assertEquals(code, a.getCode());
        });
    }

    @Test
    public void findByCode() {
        Optional<Acquirer> acquirer = acquirerRepository.findByCode(code);

        acquirer.ifPresent(a -> {
            assertTrue(a.getId() > 0);
            assertEquals(name, a.getName());
        });
    }

    @Test
    public void existsByName() {
        assertTrue(acquirerRepository.existsByName(name));
    }

    @Test
    public void existsByCode() {
        assertTrue(acquirerRepository.existsByCode(code));
    }

}
