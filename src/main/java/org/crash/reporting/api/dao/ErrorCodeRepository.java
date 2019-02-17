package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ErrorCodeRepository extends JpaRepository<ErrorCode, Integer> {

    Optional<ErrorCode> findByName(String name);

    boolean existsByName(String name);

}
