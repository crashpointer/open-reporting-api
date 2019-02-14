package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

    Optional<List<Agent>> findByCustomerIp(String customerIp);

    Optional<List<Agent>> findByMerchantIp(String merchantIp);

}
