package org.crash.reporting.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment_method_id")
    @SequenceGenerator(name = "seq_payment_method_id", sequenceName = "seq_payment_method_id", allocationSize = 1)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private PaymentMethodEnum name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentMethodEnum getName() {
        return name;
    }

    public void setName(PaymentMethodEnum name) {
        this.name = name;
    }

}
