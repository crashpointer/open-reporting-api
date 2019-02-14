package org.crash.reporting.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Card extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_card_id")
    @SequenceGenerator(name = "seq_card_id", sequenceName = "seq_card_id", allocationSize = 1)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @NotNull
    @Size(max = 16)
    @Column(length = 16, unique = true, nullable = false)
    private String number;

    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    @Column(nullable = false)
    private byte expiryMonth;

    @NotNull
    @Column(nullable = false)
    private short expiryYear;

    private byte startMonth;

    private short startYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public byte getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(byte expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public short getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(short expiryYear) {
        this.expiryYear = expiryYear;
    }

    public byte getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(byte startMonth) {
        this.startMonth = startMonth;
    }

    public short getStartYear() {
        return startYear;
    }

    public void setStartYear(short startYear) {
        this.startYear = startYear;
    }

}
