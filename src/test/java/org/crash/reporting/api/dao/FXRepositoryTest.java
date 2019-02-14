package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.FX;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FXRepositoryTest extends AbstractDAOTest {

    @Autowired
    FXRepository fxRepository;

    private static final String currency = "USD";

    @Before
    public void setUp() {
        if (!fxRepository.existsByName(currency)) {
            FX fx = new FX();
            fx.setName(currency);
            fxRepository.save(fx);
        }
    }

    @Test
    public void findByName() {
        Optional<FX> fx = fxRepository.findByName(currency);

        assertTrue(fx.isPresent());
        assertTrue(fx.get().getId() > 0);
        assertEquals(currency, fx.get().getName());
    }

    @Test
    public void existsByName() {
        assertTrue(fxRepository.existsByName(currency));
    }

}
