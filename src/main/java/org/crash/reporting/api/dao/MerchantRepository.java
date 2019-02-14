package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Merchant;
import org.crash.reporting.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

    Optional<Merchant> findByName(String name);

    Optional<Merchant> findByUser(User user);

    boolean existsByName(String name);

}
