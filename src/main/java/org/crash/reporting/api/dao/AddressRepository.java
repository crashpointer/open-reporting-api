package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Address;
import org.crash.reporting.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<List<Address>> findByCustomer(Customer customer);

    Optional<List<Address>> findByTitle(String title);

    Optional<List<Address>> findByFirstName(String firstName);

    Optional<List<Address>> findByLastName(String lastName);

}
