package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Status;
import org.crash.reporting.api.model.StatusEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StatusRepositoryTest extends AbstractDAOTest {

    @Autowired
    StatusRepository statusRepository;

    @Before
    public void setUp() {
        for (StatusEnum status : StatusEnum.values()) {
            Optional<Status> stat = statusRepository.findByName(status);

            if (!stat.isPresent()) {
                Status newStatus = new Status();
                newStatus.setName(status);

                statusRepository.save(newStatus);
            }
        }
    }

    @Test
    public void findByName() {
        for (StatusEnum item : StatusEnum.values()) {
            Optional<Status> status = statusRepository.findByName(item);
            assertTrue(status.isPresent());
            assertEquals(item, status.get().getName());
        }
    }

    @Test
    public void existsByName() {
        for (StatusEnum status : StatusEnum.values()) {
            assertTrue(statusRepository.existsByName(status));
        }
    }

}
