package org.crash.reporting.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Acquirer extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acquirer_id")
    @SequenceGenerator(name = "seq_acquirer_id", sequenceName = "seq_acquirer_id", allocationSize = 1)
    private int id;

    @NotNull
    @Size(max = 64)
    @Column(length = 64, nullable = false)
    private String name;

    @Size(max = 4)
    @Column(length = 4, unique = true)
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
