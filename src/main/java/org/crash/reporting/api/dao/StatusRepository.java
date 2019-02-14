package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Status;
import org.crash.reporting.api.model.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Integer> {

    Optional<Status> findByName(StatusEnum name);

    boolean existsByName(StatusEnum name);

}
