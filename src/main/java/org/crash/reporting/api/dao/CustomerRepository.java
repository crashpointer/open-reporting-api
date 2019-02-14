package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<List<Customer>> findByName(String name);

    Optional<Customer> findByEmail(String email);

}
