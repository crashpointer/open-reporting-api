package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Agent;
import org.crash.reporting.api.model.CustomerUserAgentEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AgentRepositoryTest extends AbstractDAOTest {

    @Autowired
    AgentRepository agentRepository;

    private static final String customerIp = "192.168.1.2";

    private static final CustomerUserAgentEnum customerUserAgent = CustomerUserAgentEnum.Agent;

    private static final String merchantIp = "127.0.0.1";

    @Before
    public void setUp() {
        Agent agent = new Agent();
        agent.setCustomerIp(customerIp);
        agent.setCustomerUserAgent(customerUserAgent);
        agent.setMerchantIp(merchantIp);

        agentRepository.save(agent);
    }

    @Test
    public void findByCustomerIp() {
        Optional<List<Agent>> agent = agentRepository.findByCustomerIp(customerIp);
        assertTrue(agent.isPresent());
        agent.get().forEach(a -> {
            assertEquals(customerIp, a.getCustomerIp());
        });
    }

    @Test
    public void findByMerchantIp() {
        Optional<List<Agent>> agent = agentRepository.findByMerchantIp(merchantIp);
        assertTrue(agent.isPresent());
        agent.get().forEach(a -> {
            assertEquals(merchantIp, a.getMerchantIp());
        });
    }

}
