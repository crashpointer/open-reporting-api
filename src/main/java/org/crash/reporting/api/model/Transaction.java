package org.crash.reporting.api.model;

import org.crash.reporting.api.payload.response.TransactionInfo;
import org.crash.reporting.api.payload.response.TransactionReport;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SqlResultSetMapping(
        name = "TransactionInfoMapping",
        classes = @ConstructorResult(
                targetClass = TransactionInfo.class,
                columns = {
                        @ColumnResult(name = "fx_id", type = Integer.class),
                        @ColumnResult(name = "original_amount", type = Integer.class),
                        @ColumnResult(name = "original_currency", type = String.class),
                        @ColumnResult(name = "customer_id", type = Integer.class),
                        @ColumnResult(name = "created_at", type = LocalDateTime.class),
                        @ColumnResult(name = "updated_at", type = LocalDateTime.class),
                        @ColumnResult(name = "number", type = String.class),
                        @ColumnResult(name = "expiry_month", type = Byte.class),
                        @ColumnResult(name = "expiry_year", type = Short.class),
                        @ColumnResult(name = "start_month", type = Byte.class),
                        @ColumnResult(name = "start_year", type = Short.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "birthday", type = LocalDate.class),
                        @ColumnResult(name = "gender", type = Boolean.class),
                        @ColumnResult(name = "billing_title", type = String.class),
                        @ColumnResult(name = "billing_first_name", type = String.class),
                        @ColumnResult(name = "billing_last_name", type = String.class),
                        @ColumnResult(name = "billing_company", type = String.class),
                        @ColumnResult(name = "billing_address1", type = String.class),
                        @ColumnResult(name = "billing_address2", type = String.class),
                        @ColumnResult(name = "billing_city", type = String.class),
                        @ColumnResult(name = "billing_post_code", type = String.class),
                        @ColumnResult(name = "billing_state", type = String.class),
                        @ColumnResult(name = "billing_country", type = String.class),
                        @ColumnResult(name = "billing_phone", type = String.class),
                        @ColumnResult(name = "billing_fax", type = String.class),
                        @ColumnResult(name = "shipping_title", type = String.class),
                        @ColumnResult(name = "shipping_first_name", type = String.class),
                        @ColumnResult(name = "shipping_last_name", type = String.class),
                        @ColumnResult(name = "shipping_company", type = String.class),
                        @ColumnResult(name = "shipping_address1", type = String.class),
                        @ColumnResult(name = "shipping_address2", type = String.class),
                        @ColumnResult(name = "shipping_city", type = String.class),
                        @ColumnResult(name = "shipping_post_code", type = String.class),
                        @ColumnResult(name = "shipping_state", type = String.class),
                        @ColumnResult(name = "shipping_country", type = String.class),
                        @ColumnResult(name = "shipping_phone", type = String.class),
                        @ColumnResult(name = "shipping_fax", type = String.class),
                        @ColumnResult(name = "merchant_id", type = Integer.class),
                        @ColumnResult(name = "merchant_name", type = String.class),
                        @ColumnResult(name = "transaction_id", type = Integer.class),
                        @ColumnResult(name = "transactionuuid", type = String.class),
                        @ColumnResult(name = "reference_no", type = String.class),
                        @ColumnResult(name = "transaction_status", type = String.class),
                        @ColumnResult(name = "channel", type = String.class),
                        @ColumnResult(name = "custom_data", type = String.class),
                        @ColumnResult(name = "chain_id", type = String.class),
                        @ColumnResult(name = "operation_name", type = String.class),
                        @ColumnResult(name = "transaction_code", type = String.class),
                        @ColumnResult(name = "message", type = String.class),
                        @ColumnResult(name = "transaction_created_at", type = LocalDateTime.class),
                        @ColumnResult(name = "transaction_updated_at", type = LocalDateTime.class),
                        @ColumnResult(name = "agent_id", type = Integer.class),
                        @ColumnResult(name = "customer_ip", type = String.class),
                        @ColumnResult(name = "customer_user_agent", type = String.class),
                        @ColumnResult(name = "merchant_ip", type = String.class),
                }
        )
)
@SqlResultSetMapping(
        name = "TransactionReportMapping",
        classes = @ConstructorResult(
                targetClass = TransactionReport.class,
                columns = {
                        @ColumnResult(name = "currency", type = String.class),
                        @ColumnResult(name = "count", type = Long.class),
                        @ColumnResult(name = "total", type = Long.class)
                }
        )
)
@Entity
public class Transaction extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transaction_id")
    @SequenceGenerator(name = "seq_transaction_id", sequenceName = "seq_transaction_id", allocationSize = 1)
    private int id;

    @NotNull
    @Size(max = 32)
    @Column(length = 32, unique = true)
    private String transactionUUID;

    @NotNull
    @Column(nullable = false)
    private Date transactionDate;

    @NotNull
    @Size(max = 32)
    @Column(length = 32, unique = true)
    private String referenceNo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "fx_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private FX fx;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Merchant merchant;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "acquirer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Acquirer acquirer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "payment_method_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private PaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;

    private int amount;

    @Size(max = 512)
    @Column(length = 512)
    private String message;

    @Size(max = 4)
    @Column(length = 4)
    private String channel;

    @Size(max = 16)
    @Column(length = 16)
    private String chainId;

    @Size(max = 2)
    @Column(length = 2)
    private String code;

    @NotNull
    @Column(nullable = false)
    private boolean refundable = false;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "billing_address_id", nullable = false)
    private Address billingAddress;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "shipping_address_id", nullable = false)
    private Address shippingAddress;

    @Size(max = 256)
    @Column(length = 256)
    private String customData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "error_code_id")
    private ErrorCode errorCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionUUID() {
        return transactionUUID;
    }

    public void setTransactionUUID(String transactionUUID) {
        this.transactionUUID = transactionUUID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public FX getFx() {
        return fx;
    }

    public void setFx(FX fx) {
        this.fx = fx;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
