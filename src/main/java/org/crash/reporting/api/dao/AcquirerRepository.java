package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Acquirer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcquirerRepository extends JpaRepository<Acquirer, Integer> {

    Optional<Acquirer> findByName(String name);

    Optional<Acquirer> findByCode(String code);

    boolean existsByName(String name);

    boolean existsByCode(String code);

}
