package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.FX;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FXRepository extends JpaRepository<FX, Integer> {

    Optional<FX> findByName(String name);

    boolean existsByName(String name);

}
