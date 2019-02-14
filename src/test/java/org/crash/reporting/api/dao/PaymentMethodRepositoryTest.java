package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.PaymentMethod;
import org.crash.reporting.api.model.PaymentMethodEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PaymentMethodRepositoryTest extends AbstractDAOTest {

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Before
    public void setUp() {
        for (PaymentMethodEnum paymentMethodEnum : PaymentMethodEnum.values()) {
            if (!paymentMethodRepository.existsByName(paymentMethodEnum)) {
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setName(paymentMethodEnum);
                paymentMethodRepository.save(paymentMethod);
            }
        }
    }

    @Test
    public void findByName() {
        for (PaymentMethodEnum paymentMethodEnum : PaymentMethodEnum.values()) {
            Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findByName(paymentMethodEnum);
            assertTrue(paymentMethod.isPresent());
            assertEquals(paymentMethodEnum, paymentMethod.get().getName());
        }
    }

    @Test
    public void existsByName() {
        for (PaymentMethodEnum paymentMethodEnum : PaymentMethodEnum.values()) {
            assertTrue(paymentMethodRepository.existsByName(paymentMethodEnum));
        }
    }

}
