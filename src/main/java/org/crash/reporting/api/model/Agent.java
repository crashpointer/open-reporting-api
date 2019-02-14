package org.crash.reporting.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Agent extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_agent_id")
    @SequenceGenerator(name = "seq_agent_id", sequenceName = "seq_agent_id", allocationSize = 1)
    private int id;

    @NotNull
    @Size(max = 16)
    private String customerIp;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private CustomerUserAgentEnum customerUserAgent;

    @NotNull
    @Size(max = 16)
    private String merchantIp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public CustomerUserAgentEnum getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(CustomerUserAgentEnum customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public String getMerchantIp() {
        return merchantIp;
    }

    public void setMerchantIp(String merchantIp) {
        this.merchantIp = merchantIp;
    }

}
