package org.crash.reporting.api.payload.response;

public class Agent {

    private int id;

    private String customerIp;

    private String customerUserAgent;

    private String merchantIp;

    Agent(int id, String customerIp, String customerUserAgent, String merchantIp) {
        this.id = id;
        this.customerIp = customerIp;
        this.customerUserAgent = customerUserAgent;
        this.merchantIp = merchantIp;
    }

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

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public String getMerchantIp() {
        return merchantIp;
    }

    public void setMerchantIp(String merchantIp) {
        this.merchantIp = merchantIp;
    }

}
