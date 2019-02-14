package org.crash.reporting.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_operation_id")
    @SequenceGenerator(name = "seq_operation_id", sequenceName = "seq_operation_id", allocationSize = 1)
    private int id;

    @NotNull
    @Size(max = 8)
    @Column(length = 8, unique = true, nullable = false)
    private String name;

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

}
