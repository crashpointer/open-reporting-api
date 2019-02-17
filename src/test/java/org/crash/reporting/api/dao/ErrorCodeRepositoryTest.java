package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.ErrorCode;
import org.crash.reporting.api.model.ErrorCodeEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ErrorCodeRepositoryTest extends AbstractDAOTest {

    @Autowired
    ErrorCodeRepository errorCodeRepository;

    @Before
    public void setUp() {
        for (ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()) {
            if (!errorCodeRepository.existsByName(errorCodeEnum.toString())) {
                ErrorCode errorCode = new ErrorCode();
                errorCode.setName(errorCodeEnum.toString());
                errorCodeRepository.save(errorCode);
            }
        }
    }

    @Test
    public void findByName() {
        for (ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()) {
            Optional<ErrorCode> errorCode =
                    errorCodeRepository.findByName(errorCodeEnum.toString());
            assertTrue(errorCode.isPresent());
            assertEquals(errorCodeEnum.toString(), errorCode.get().getName());
        }
    }

    @Test
    public void existsByName() {
        for (ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()) {
            assertTrue(errorCodeRepository.existsByName(errorCodeEnum.toString()));
        }
    }

}
