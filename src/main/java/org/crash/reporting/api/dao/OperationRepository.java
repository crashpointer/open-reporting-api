package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Integer> {

    Optional<Operation> findByName(String name);

    boolean existsByName(String name);

}
