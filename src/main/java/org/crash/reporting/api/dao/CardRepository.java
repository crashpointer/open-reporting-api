package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Card;
import org.crash.reporting.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {

    Optional<Card> findByNumber(String number);

    Optional<List<Card>> findByCustomer(Customer customer);

    boolean existsByNumber(String number);

}
