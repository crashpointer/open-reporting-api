package org.crash.reporting.api.payload.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionInfo {

    private FX fx;

    private CustomerInfo customerInfo;

    private Merchant merchant;

    private Transaction transaction;

    private Agent agent;

    public TransactionInfo(int fxId, int originalAmount, String originalCurrency, int id,
                           LocalDateTime createdAt, LocalDateTime updatedAt, String number,
                           byte expiryMonth, short expiryYear, byte startMonth, short startYear,
                           String email, LocalDate birthday, boolean gender, String billingTitle,
                           String billingFirstName, String billingLastName, String billingCompany,
                           String billingAddress1, String billingAddress2, String billingCity,
                           String billingPostCode, String billingState, String billingCountry,
                           String billingPhone, String billingFax, String shippingTitle,
                           String shippingFirstName, String shippingLastName, String shippingCompany,
                           String shippingAddress1, String shippingAddress2, String shippingCity,
                           String shippingPostCode, String shippingState, String shippingCountry,
                           String shippingPhone, String shippingFax, int merchantId, String merchantName,
                           int transactionId, String transactionUUID, String referenceNo,
                           String transactionStatus, String channel, String customData,
                           String chainId, String operationName, String transactionCode,
                           String transactionMessage, LocalDateTime transactionCreatedAt,
                           LocalDateTime transactionUpdatedAt, int agentId,
                           String customerIp, String customerUserAgent, String merchantIp) {

        fx = new FX(fxId, originalAmount, originalCurrency);
        merchant = new Merchant(merchantId, merchantName);
        agent = new Agent(agentId, customerIp, customerUserAgent, merchantIp);

        transaction = new Transaction(transactionId, transactionUUID, referenceNo,
                transactionStatus, channel, customData, chainId, operationName, transactionCode,
                transactionMessage, transactionCreatedAt, transactionUpdatedAt);

        customerInfo = new CustomerInfo(id, createdAt, updatedAt, number,
                expiryMonth, expiryYear, startMonth, startYear,
                email, birthday, gender, billingTitle,
                billingFirstName, billingLastName, billingCompany,
                billingAddress1, billingAddress2, billingCity,
                billingPostCode, billingState, billingCountry,
                billingPhone, billingFax, shippingTitle,
                shippingFirstName, shippingLastName, shippingCompany,
                shippingAddress1, shippingAddress2, shippingCity,
                shippingPostCode, shippingState, shippingCountry,
                shippingPhone, shippingFax);
    }

    public FX getFx() {
        return fx;
    }

    public void setFx(FX fx) {
        this.fx = fx;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
