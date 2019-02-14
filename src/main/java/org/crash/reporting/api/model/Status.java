package org.crash.reporting.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_id")
    @SequenceGenerator(name = "seq_status_id", sequenceName = "seq_status_id", allocationSize = 1)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 8, nullable = false)
    private StatusEnum name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusEnum getName() {
        return name;
    }

    public void setName(StatusEnum name) {
        this.name = name;
    }

}
