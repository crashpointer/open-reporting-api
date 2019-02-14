package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.RoleEnum;
import org.crash.reporting.api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleEnum name);

    boolean existsByName(RoleEnum name);

}
