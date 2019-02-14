package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.PaymentMethod;
import org.crash.reporting.api.model.PaymentMethodEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

    Optional<PaymentMethod> findByName(PaymentMethodEnum name);

    boolean existsByName(PaymentMethodEnum name);

}
