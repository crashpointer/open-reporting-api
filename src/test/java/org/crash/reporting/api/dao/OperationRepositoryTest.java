package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Operation;
import org.crash.reporting.api.model.OperationEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OperationRepositoryTest extends AbstractDAOTest {

    @Autowired
    OperationRepository operationRepository;

    @Before
    public void setUp() {
        for (OperationEnum operationEnum : OperationEnum.values()) {
            if (!operationRepository.existsByName(operationEnum.toString())) {
                Operation operation = new Operation();
                operation.setName(operationEnum.toString());
                operationRepository.save(operation);
            }
        }
    }

    @Test
    public void findByName() {
        for (OperationEnum operationEnum : OperationEnum.values()) {
            Optional<Operation> operation = operationRepository.findByName(operationEnum.toString());
            assertTrue(operation.isPresent());
            assertEquals(operationEnum.toString(), operation.get().getName());
        }
    }

    @Test
    public void existsByName() {
        for (OperationEnum operationEnum : OperationEnum.values()) {
            assertTrue(operationRepository.existsByName(operationEnum.toString()));
        }
    }

}
